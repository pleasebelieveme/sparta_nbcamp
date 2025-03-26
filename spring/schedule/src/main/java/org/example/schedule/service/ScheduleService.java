package org.example.schedule.service;

import java.util.List;

import org.example.schedule.dto.MemberRequestDto;
import org.example.schedule.dto.MemberResponseDto;
import org.example.schedule.dto.ScheduleRequestDto;
import org.example.schedule.dto.ScheduleResponseDto;

public interface ScheduleService {

	ScheduleResponseDto createSchedule(ScheduleRequestDto dto);
	List<ScheduleResponseDto> findAllSchedules();
	ScheduleResponseDto findScheduleById(Long id);
	ScheduleResponseDto updateSchedule(Long id, String content, String writer, String schedulePwd);
	void deleteSchedule(Long id);
}
