package org.example.layerdmemo.dto;

import org.example.layerdmemo.entity.Memo;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MemoResponseDto {

	private Long id;
	private String title;
	private String contents;

	public MemoResponseDto(Memo memo) {
		this.id = memo.getId();
		this.title = memo.getTitle();
		this.contents = memo.getContents();
	}
}
