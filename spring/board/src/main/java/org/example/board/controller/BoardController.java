package org.example.board.controller;

import java.util.List;

import org.example.board.dto.BoardResponseDto;
import org.example.board.dto.BoardWithAgeResponseDto;
import org.example.board.dto.CreateBoardRequestDto;
import org.example.board.service.BoardService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
@Repository
@RestController
@RequestMapping("/boards")
@RequiredArgsConstructor
public class BoardController {

	private final BoardService boardService;

	@PostMapping
	public ResponseEntity<BoardResponseDto> save(@RequestBody CreateBoardRequestDto requestDto) {
		BoardResponseDto boardResponseDto =
			boardService.save(
				requestDto.getTitle(),
				requestDto.getContents(),
				requestDto.getUsername()
			);
		return new ResponseEntity<>(boardResponseDto, HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<BoardResponseDto>> findAll() {
		List<BoardResponseDto> boardResponseDtoList = boardService.findAll();

		return new ResponseEntity<>(boardResponseDtoList, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<BoardWithAgeResponseDto> findById(@PathVariable Long id) {
		BoardWithAgeResponseDto boardWithAgeResponseDto = boardService.findById(id);
		return new ResponseEntity<>(boardWithAgeResponseDto, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete (@PathVariable Long id) {
		boardService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
