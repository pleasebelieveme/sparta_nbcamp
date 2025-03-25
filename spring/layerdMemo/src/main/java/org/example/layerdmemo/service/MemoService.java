package org.example.layerdmemo.service;

import java.util.List;

import org.example.layerdmemo.dto.MemoRequestDto;
import org.example.layerdmemo.dto.MemoResponseDto;

public interface MemoService {
	MemoResponseDto saveMemo(MemoRequestDto dto);
	List<MemoResponseDto> findAllMemos();
	MemoResponseDto findMemoById(Long id);
	MemoResponseDto updateMemo(Long id, String title, String contents);
	MemoResponseDto updateTitle(Long id, String title, String contents);
	void deleteMemo(Long id);
}
