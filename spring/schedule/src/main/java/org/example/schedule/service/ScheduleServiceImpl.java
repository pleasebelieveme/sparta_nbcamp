package org.example.schedule.service;

import java.util.List;

import org.example.schedule.dto.ScheduleRequestDto;
import org.example.schedule.dto.ScheduleResponseDto;
import org.example.schedule.entity.Schedule;
import org.example.schedule.repository.ScheduleRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ScheduleServiceImpl implements ScheduleService {

	private final ScheduleRepository scheduleRepository;

	@Override
	public ScheduleResponseDto createSchedule(ScheduleRequestDto dto) {
		Schedule schedule = new Schedule(dto.getScheduleContent(), dto.getWriter(), dto.getSchedulePwd());
		return scheduleRepository.createSchedule(schedule);
	}

	@Override
	public List<ScheduleResponseDto> findAllSchedules() {
		return scheduleRepository.findAllSchedules();
	}

	@Override
	public ScheduleResponseDto findScheduleById(Long id) {
		Schedule schedule = scheduleRepository.findScheduleByIdOrElseThrow(id);
		return new ScheduleResponseDto(schedule);
	}

	@Transactional
	@Override
	public ScheduleResponseDto updateSchedule(Long id, String content, String writer, String schedulePwd) {
		if(content == null || writer == null || schedulePwd == null) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The title and contents are required values.");
		}
		int updatedRow = scheduleRepository.updateSchedule(id, content, writer, schedulePwd);
		if (updatedRow == 0) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exist id = " + id);
		}
		Schedule schedule = scheduleRepository.findScheduleByIdOrElseThrow(id);
		return new ScheduleResponseDto(schedule);
	}

	@Override
	public void deleteSchedule(Long id) {
		int deletedRow = scheduleRepository.deleteSchedule(id);
		if (deletedRow == 0) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exist id = " + id);
		}
	}
}
