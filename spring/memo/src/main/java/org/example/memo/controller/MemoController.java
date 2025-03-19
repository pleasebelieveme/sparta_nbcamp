package org.example.memo.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.example.memo.dto.MemoRequestDto;
import org.example.memo.dto.MemoResponseDto;
import org.example.memo.entity.Memo;
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

@RestController
@RequestMapping("/memos")// 데이터를 json으로 다룰 것이기에 선
public class MemoController {

	private final Map<Long, Memo> memoList = new HashMap<>();

	@PostMapping
	public ResponseEntity createMemo(@RequestBody MemoRequestDto dto) {

		// 식별자가 1씩 증가하도록
		// HashMap을 사용하기 때문에 마지막 값이 없어서 순회하면서 max값을 찾아야함
		// TreeMap인 경우는 lastKey() 사
		Long memoId = memoList.isEmpty() ? 1 : Collections.max(memoList.keySet()) + 1;

		// 요청받은 데이터로 메모를 생성
		Memo memo = new Memo(memoId, dto.getTitle(), dto.getContents());

		// Inmemory DB에 메모 저장(위에 선언된 필드(Map)에 저장)
		memoList.put(memoId, memo);

		return new ResponseEntity<>(new MemoResponseDto(memo), HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<MemoResponseDto> findMemoById(@PathVariable Long id) {

		Memo memo = memoList.get(id);
		if(memo == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		// else {
			return new ResponseEntity(new MemoResponseDto(memo), HttpStatus.OK);
		// }
	}

	@GetMapping
	public List<MemoResponseDto> findAllMemos() {

		// init List, 리스트는 인터페이스이기 때문에 구현체를 사용해서 초기화 해야 한다. new로 인스턴스화 할 수 없다.
		List<MemoResponseDto> responseList = new ArrayList<>();

		// HashMap<Memo> -> List<MemoResponseDto>
		for (Memo memo : memoList.values()) {
			responseList.add(new MemoResponseDto(memo));
		}
		// // Map to List
		// responseList = memoList.values().stream().map(MemoResponseDto::new).toList();
		return responseList;
	}

	@PutMapping("/{id}")
	public ResponseEntity<MemoResponseDto> updateMemoById(
			@PathVariable Long id,
			@RequestBody MemoRequestDto dto
	) {
		Memo memo = memoList.get(id);
		if(memo == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		if(dto.getTitle() == null || dto.getContents() == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		memo.update(dto);
		return new ResponseEntity<>(new MemoResponseDto(memo), HttpStatus.OK);
	}

	@PatchMapping("/{id}")
	public ResponseEntity<MemoResponseDto> updateTitle(
			@PathVariable Long id,
			@RequestBody MemoRequestDto dto
	) {
		Memo memo = memoList.get(id);
		// NPE 방지
		if(memo == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		if(dto.getTitle() == null || dto.getContents() != null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		memo.updateTitle(dto);

		return new ResponseEntity<>(new MemoResponseDto(memo), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteMemoById(@PathVariable Long id) {
		// memoList의 Key값에 id를 포함하고 있다면
		if(memoList.containsKey(id)) {
			memoList.remove(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
