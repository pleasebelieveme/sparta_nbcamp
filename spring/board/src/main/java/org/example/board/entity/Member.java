package org.example.board.entity;

import jakarta.persistence.*;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;

@Getter
@Entity // 기본키가 필수
@Table(name = "member")
public class Member extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // MySQL은 IDENTITY로 설정
	private Long id;

	@Column(nullable = false, unique = true) // null 불가
	private String username;

	@Column(nullable = false)
	private String password;

	private Integer age;

	// @Entity가 붙은 클래스는 기본생성자가 없으면 에러
	public Member() {}

	public Member(String username, String password, Integer age) {
		this.username = username;
		this.password = password;
		this.age = age;
	}

	public void updatePassword(String password) {
		this.password = password;
	}
}
