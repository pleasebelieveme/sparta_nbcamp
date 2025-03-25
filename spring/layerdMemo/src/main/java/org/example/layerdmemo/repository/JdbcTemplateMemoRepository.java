package org.example.layerdmemo.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.sql.DataSource;

import org.example.layerdmemo.dto.MemoResponseDto;
import org.example.layerdmemo.entity.Memo;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

@Repository
public class JdbcTemplateMemoRepository implements MemoRepository {

	private final JdbcTemplate jdbcTemplate;

	public JdbcTemplateMemoRepository(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public MemoResponseDto saveMemo(Memo memo) {
		// INSERT Query 직접 작성하지 않아도 된다.
		SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
		jdbcInsert.withTableName("memo").usingGeneratedKeyColumns("id");

		// Map은 인터페이스이기 때문에 구현체가 필요하다.
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("title", memo.getTitle());
		parameters.put("contents", memo.getContents());

		// 저장 후 생성된 key값 Number 타입으로 반환하는 메서드
		Number key = jdbcInsert.executeAndReturnKey(new MapSqlParameterSource(parameters));

		return new MemoResponseDto(key.longValue(), memo.getTitle(), memo.getContents());
	}

	@Override
	public List<MemoResponseDto> findAllMemos() {
		return jdbcTemplate.query("SELECT id, title, contents FROM memo", memoRowMapper());
	}

	@Override
	public Optional<Memo> findMemoById(Long id) {
		List<Memo> result = jdbcTemplate.query("SELECT id, title, contents FROM memo WHERE id = ?", memoRowMapperV2(), id);
		return result.stream().findAny(); // Optional형태의 메모로 변경
	}

	@Override
	public Memo findMemoByIdOrElseThrow(Long id) {
		List<Memo> result = jdbcTemplate.query("SELECT id, title, contents FROM memo WHERE id = ?", memoRowMapperV2(), id);
		return result.stream().findAny().orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exists id = " + id));
	}

	@Override
	public int updateMemo(Long id, String title, String contents) {
		return jdbcTemplate.update("UPDATE MEMO SET title = ?, contents = ? WHERE id = ?", title, contents, id);
	}

	@Override
	public int updateTitle(Long id, String title) {
		return jdbcTemplate.update("UPDATE memo SET title = ? WHERE id = ?", title, id);
	}

	@Override
	public int deleteMemo(Long id) {
		return jdbcTemplate.update("DELETE FROM memo WHERE id = ?", id);
	}

	private RowMapper<MemoResponseDto> memoRowMapper() {
		return new RowMapper<MemoResponseDto>() {
			@Override
			public MemoResponseDto mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new MemoResponseDto(
					rs.getLong("id"),
					rs.getString("title"),
					rs.getString("contents")
				);
			}
		};
	}

	private RowMapper<Memo> memoRowMapperV2() {
		return new RowMapper<Memo>() {
			@Override
			public Memo mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new Memo(
					rs.getLong("id"),
					rs.getString("title"),
					rs.getString("contents")
				);
			}
		};
	}

}
