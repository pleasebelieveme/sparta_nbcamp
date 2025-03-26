package org.example.schedule.entity;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Schedule {
	private Long scheduleId;
	private String scheduleContent;
	private String writer;
	private String schedulePwd;
	private Timestamp updatedAt;

	public Schedule(String scheduleContent, String writer, String schedulePwd) {
		this.scheduleContent = scheduleContent;
		this.writer = writer;
		this.schedulePwd = schedulePwd;
	}

}
