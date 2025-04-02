package org.example.board.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Table(name = "board")
public class Board extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String title;

	@Column(columnDefinition = "longtext")
	private String contents;

	@ManyToOne
	@JoinColumn(name = "member_id")
	private Member member;

	public Board() {}
	// id는 자동생성, member는 참조값이어서 생략
	public Board(String title, String contents) {
		this.title = title;
		this.contents = contents;
	}

	// 작성자 추가
	public void setMember(Member member) {
		this.member = member;
	}
}
