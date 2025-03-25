package org.example.schedule.dto;

import org.example.schedule.entity.Member;

public class MemberResponseDto {

	private Long id;
	private String name;
	private String pwd;

	public MemberResponseDto(Member member) {
		this.id = member.getId();
		this.name = member.getName();
		this.pwd = member.getPwd();
	}
}
