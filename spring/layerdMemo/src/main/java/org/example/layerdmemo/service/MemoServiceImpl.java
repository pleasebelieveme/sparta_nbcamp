package org.example.layerdmemo.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.example.layerdmemo.dto.MemoRequestDto;
import org.example.layerdmemo.dto.MemoResponseDto;
import org.example.layerdmemo.entity.Memo;
import org.example.layerdmemo.repository.MemoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

/**
 * Annotation @Service는 @Component와 같다, Spring Bean으로 등록한다는 뜻.
 * Spring Bean으로 등록되면 다른 클래스에서 주입하여 사용할 수 있다.
 * 명시적으로 Service Layer 라는것을 나타낸다.
 * 비지니스 로직을 수행한다.
 */

@Service // @Controller와 다른건 Service를 component로 등록한다는 것 뿐이다.
public class MemoServiceImpl implements MemoService {

	private final MemoRepository memoRepository;

	public MemoServiceImpl(MemoRepository memoRepository) {
		this.memoRepository = memoRepository;
	}

	@Override
	public MemoResponseDto saveMemo(MemoRequestDto dto) {

		// 요청받은 데이터로 메모객체 생성
		Memo memo = new Memo(dto.getTitle(), dto.getContents());
		// DB 저장
		return memoRepository.saveMemo(memo);
	}

	@Override
	public List<MemoResponseDto> findAllMemos() {
		return memoRepository.findAllMemos();
	}

	@Override
	public MemoResponseDto findMemoById(Long id) {
		// 수정 전
		// Optional<Memo> optionalMemo = memoRepository.findMemoById(id);
		Memo memo = memoRepository.findMemoByIdOrElseThrow(id);

		// 아래 코드는 Controller에서 응답하는 형태다
		// if(memo == null) {
		// 	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		// }

		// 해결방법
		// if(optionalMemo.isEmpty()) {
		// 	throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exist id = " + id);
		// }

		return new MemoResponseDto(memo);
	}

	@Transactional // 아래의 메서드가 논리적인 작업단위로 묶임
	@Override
	public MemoResponseDto updateMemo(Long id, String title, String contents) {

		// 필수값 검증
		if(title == null || contents == null) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The title and contents are required values.");
		}

		int updatedRow = memoRepository.updateMemo(id, title, contents);

		// NPE방지
		if (updatedRow == 0) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exist id = " + id);
		}
		Memo memo = memoRepository.findMemoByIdOrElseThrow(id);
		return new MemoResponseDto(memo);
	}

	@Transactional
	@Override
	public MemoResponseDto updateTitle(Long id, String title, String contents) {
		// 필수값 검증
		if(title == null || contents != null) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The title and contents are required values.");
		}

		int updatedRow = memoRepository.updateTitle(id, title);

		// NPE방지
		if (updatedRow == 0) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exist id = " + id);
		}
		Memo memo = memoRepository.findMemoByIdOrElseThrow(id);
		return new MemoResponseDto(memo);
	}

	@Override
	public void deleteMemo(Long id) {
		int deletedRow = memoRepository.deleteMemo(id);
		if (deletedRow == 0) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exist id = " + id);
		}
	}
}
