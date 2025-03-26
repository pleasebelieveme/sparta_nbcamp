package org.example.schedule.controller;

import java.util.List;

import org.example.schedule.dto.MemberRequestDto;
import org.example.schedule.dto.MemberResponseDto;
import org.example.schedule.dto.ScheduleRequestDto;
import org.example.schedule.dto.ScheduleResponseDto;
import org.example.schedule.service.ScheduleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/schedules")
public class ScheduleController {

	private final ScheduleService scheduleService;

	@PostMapping
	public ResponseEntity<ScheduleResponseDto> createSchedule(@RequestBody ScheduleRequestDto dto) {
		// log.info("Create Schedule Request: {}", dto);
		return new ResponseEntity<>(scheduleService.createSchedule(dto), HttpStatus.CREATED);
	}

	@GetMapping
	public List<ScheduleResponseDto> findAllSchedules() {
		return scheduleService.findAllSchedules();
	}

	@GetMapping("/{id}")
	public ResponseEntity<ScheduleResponseDto> findScheduleById(@PathVariable Long id) {
		return new ResponseEntity<>(scheduleService.findScheduleById(id), HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<ScheduleResponseDto> updateSchedule(
		@PathVariable Long id,
		@RequestBody ScheduleRequestDto dto
	) {
		return new ResponseEntity<>(scheduleService.updateSchedule(id, dto.getScheduleContent(), dto.getWriter(), dto.getSchedulePwd()), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteMemo(@PathVariable Long id) {
		scheduleService.deleteSchedule(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
