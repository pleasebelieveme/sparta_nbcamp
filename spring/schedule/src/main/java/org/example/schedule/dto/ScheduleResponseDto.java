package org.example.schedule.dto;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import org.example.schedule.entity.Schedule;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ScheduleResponseDto {

	private Long scheduleId;
	private String scheduleContent;
	private String writer;
	private String schedulePwd;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime createdAt;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime updatedAt;

	public ScheduleResponseDto(Schedule schedule) {
		this.scheduleId = schedule.getScheduleId();
		this.scheduleContent = schedule.getScheduleContent();
		this.writer = schedule.getWriter();
		this.schedulePwd = schedule.getSchedulePwd();
		this.createdAt = schedule.getCreatedAt();
		this.updatedAt = schedule.getUpdatedAt();
	}
}
