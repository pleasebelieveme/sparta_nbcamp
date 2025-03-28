package org.example.schedule.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.sql.DataSource;

import org.example.schedule.dto.ScheduleResponseDto;
import org.example.schedule.entity.Schedule;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

@Repository
public class JdbcTemplateScheduleRepository implements ScheduleRepository{

	private final JdbcTemplate jdbcTemplate;

	public JdbcTemplateScheduleRepository(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public ScheduleResponseDto createSchedule(Schedule schedule) {
		SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
		jdbcInsert.withTableName("schedule").usingGeneratedKeyColumns("schedule_id");

		LocalDateTime now = LocalDateTime.now();

		Map<String, Object> parameters = new HashMap<>();
		parameters.put("schedule_content", schedule.getScheduleContent());
		parameters.put("writer", schedule.getWriter());
		parameters.put("schedule_pwd", schedule.getSchedulePwd());
		parameters.put("created_at", Timestamp.valueOf(now));
		parameters.put("updated_at", Timestamp.valueOf(now));
		Number key = jdbcInsert.executeAndReturnKey(new MapSqlParameterSource(parameters));

		// 작성, 수정일을 Timestamp로 했을 때 로직 -> 자바의 Timestamp와 DB의 Timestamp가 다름
		// // PK로 다시 조회해서 timestamp 포함 데이터 가져오기

		return new ScheduleResponseDto(key.longValue(), schedule.getScheduleContent(), schedule.getWriter(), schedule.getSchedulePwd(), now, now);
	}

	@Override
	public List<ScheduleResponseDto> findAllSchedules() {
		return jdbcTemplate.query("SELECT schedule_id, schedule_content, writer, schedule_pwd, created_at, updated_at FROM schedule", scheduleRowMapper());
	}

	@Override
	public Optional<Schedule> findScheduleById(Long id) {
		List<Schedule> result = jdbcTemplate.query("SELECT schedule_id, schedule_content, writer, schedule_pwd, created_at, updated_at FROM schedule WHERE schedule_id = ?", scheduleRowMapperV2(), id);
		return result.stream().findAny();
	}

	@Override
	public Schedule findScheduleByIdOrElseThrow(Long id) {
		List<Schedule> result = jdbcTemplate.query("SELECT schedule_id, schedule_content, writer, schedule_pwd, created_at, updated_at FROM schedule WHERE schedule_id = ?", scheduleRowMapperV2(), id);
		return result.stream().findAny().orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exists id = " + id));
	}

	@Override
	public int updateSchedule(Long id, String content, String writer, String schedulePwd) {
		return jdbcTemplate.update("UPDATE schedule SET schedule_content = ?, writer = ?, schedule_pwd = ?, updated_at = ? WHERE schedule_id = ?", content, writer, schedulePwd, Timestamp.valueOf(LocalDateTime.now()), id);
	}

	@Override
	public int deleteSchedule(Long id) {
		return jdbcTemplate.update("DELETE FROM schedule WHERE schedule_id = ?", id);
	}

	private RowMapper<ScheduleResponseDto> scheduleRowMapper() {
		return new RowMapper<ScheduleResponseDto>() {
			@Override
			public ScheduleResponseDto mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new ScheduleResponseDto(
					rs.getLong("schedule_id"),
					rs.getString("schedule_content"),
					rs.getString("writer"),
					rs.getString("schedule_pwd"),
					rs.getTimestamp("created_at").toLocalDateTime(),
					rs.getTimestamp("updated_at").toLocalDateTime()
				);
			}
		};
	}

	private RowMapper<Schedule> scheduleRowMapperV2() {
		return new RowMapper<Schedule>() {
			@Override
			public Schedule mapRow(ResultSet rs, int rowNum) throws SQLException {
				java.sql.Timestamp createdAt = rs.getTimestamp("created_at");
				java.sql.Timestamp updatedAt = rs.getTimestamp("updated_at");
				return new Schedule(
					rs.getLong("schedule_id"),
					rs.getString("schedule_content"),
					rs.getString("writer"),
					rs.getString("schedule_pwd"),
					createdAt != null ? createdAt.toLocalDateTime() : null,  // null 체크 후 변환
					updatedAt != null ? updatedAt.toLocalDateTime() : null
				);
			}
		};
	}
}
