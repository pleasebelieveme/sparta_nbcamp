package org.example.schedule.entity;

import java.time.LocalDateTime;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Schedule {
	private Long id;
	private String content;
	private String writer;
	private String pwd;
	private LocalDateTime timeStamp;

	public Schedule(String content, String writer, String pwd) {
		this.content = content;
		this.writer = writer;
		this.pwd = pwd;
	}

}
