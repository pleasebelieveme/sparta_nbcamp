package org.example.schedule.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Member {
	private Long id;
	private String name;
	private String pwd;

	public Member(String name, String pwd) {
		this.name = name;
		this.pwd = pwd;
	}
}
