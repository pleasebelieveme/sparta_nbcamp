package org.example.memo.dto;

import lombok.Getter;

@Getter
public class MemoRequestDto {

	// Memo를 생성하기 위해 클라이언트에게 전달받아야 하는 값 설정
	private String title;
	private String contents;
}
