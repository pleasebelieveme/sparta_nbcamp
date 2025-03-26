package org.example.schedule.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ScheduleRequestDto {

	private String scheduleContent;
	private String writer;
	private String schedulePwd;
}
