package org.example.layerdmemo.controller;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.example.layerdmemo.dto.MemoRequestDto;
import org.example.layerdmemo.dto.MemoResponseDto;
import org.example.layerdmemo.entity.Memo;
import org.example.layerdmemo.service.MemoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // @Controller + @ResponseBody
@RequestMapping("/memos") // Prefix
public class MemoController {

	// DB(Repository)로 이동
	// private final Map<Long, Memo> memoList = new HashMap<>();

	// 주입된 의존성을 변경할 수 없어 객체의 상태를 안전하게 유지할 수 있다.
	private final MemoService memoService;

	/**
	 * 생성자 주입
	 * 클래스가 필요로 하는 의존성을 생성자를 통해 전달하는 방식
	 * @param memoService @Service로 등록된 MemoService 구현체인 Impl
	 */
	public MemoController(MemoService memoService) {
		this.memoService = memoService;
	}

	// 1. 요청(Controller)
	@PostMapping
	public ResponseEntity<MemoResponseDto> createMemo(@RequestBody MemoRequestDto dto) {

		// 2. 비즈니스 로직
		// memoId 식별자 계산(Repository)
		// 식별자가 1씩 증가 하도록 만듦
		// Long memoId = memoList.isEmpty() ? 1 : Collections.max(memoList.keySet()) + 1;

		// 요청받은 데이터로 Memo 객체 생성(Service)
		// Memo memo = new Memo(memoId, dto.getTitle(), dto.getContents());

		// 3. DB 상호작용
		// Inmemory DB에 Memo 메모 저장(Repository)
		// memoList.put(memoId, memo);

		// 4. 응답(Controller)
		// return new ResponseEntity<>(new MemoResponseDto(memo), HttpStatus.CREATED);
		// 1~4까지 역할이 너무 많다. 2번, 3번 분리!

		// Service Layer 호출, 응답
		return new ResponseEntity<>(memoService.saveMemo(dto), HttpStatus.CREATED);
	}

	@GetMapping
	public List<MemoResponseDto> findAllmemos() {
		return memoService.findAllMemos();
	}

	@GetMapping("/{id}")
	public ResponseEntity<MemoResponseDto> findMemoById(@PathVariable Long id) {
		return new ResponseEntity<>(memoService.findMemoById(id), HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<MemoResponseDto> updateMemo(
			@PathVariable Long id,
			@RequestBody MemoRequestDto dto // json형태로 전달되니까 RequestBody
	) {
		return new ResponseEntity<>(memoService.updateMemo(id, dto.getTitle(), dto.getContents()), HttpStatus.OK);
	}

	@PatchMapping("/{id}")
	public ResponseEntity<MemoResponseDto> updateTitle(
			@PathVariable Long id,
			@RequestBody MemoRequestDto dto
	) {
		return new ResponseEntity<>(memoService.updateTitle(id, dto.getTitle(), dto.getContents()), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteMemo(@PathVariable Long id) {
		memoService.deleteMemo(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
