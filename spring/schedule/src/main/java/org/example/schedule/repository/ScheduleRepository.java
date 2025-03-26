package org.example.schedule.repository;

import java.util.List;
import java.util.Optional;

import org.example.schedule.dto.ScheduleRequestDto;
import org.example.schedule.dto.ScheduleResponseDto;
import org.example.schedule.entity.Schedule;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduleRepository {
	ScheduleResponseDto createSchedule(Schedule schedule);
	List<ScheduleResponseDto> findAllSchedules();
	Optional<Schedule> findScheduleById(Long id);
	Schedule findScheduleByIdOrElseThrow(Long id);
	int updateSchedule(Long id, String content, String writer, String schedulePwd);
	int deleteSchedule(Long id);
}
