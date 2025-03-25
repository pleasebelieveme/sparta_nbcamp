package org.example.layerdmemo.repository;

import java.util.List;
import java.util.Optional;

import org.example.layerdmemo.dto.MemoResponseDto;
import org.example.layerdmemo.entity.Memo;

public interface MemoRepository {
	MemoResponseDto saveMemo(Memo memo); // id가 없는 상태로 전달
	List<MemoResponseDto> findAllMemos();
	Optional<Memo> findMemoById(Long id);
	Memo findMemoByIdOrElseThrow(Long id);
	int updateMemo(Long id, String title, String contents);
	int updateTitle(Long id, String title);
	int deleteMemo(Long id);
}
