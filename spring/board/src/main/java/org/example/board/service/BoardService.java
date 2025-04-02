package org.example.board.service;

import java.util.List;

import org.example.board.dto.BoardResponseDto;
import org.example.board.dto.BoardWithAgeResponseDto;
import org.example.board.entity.Board;
import org.example.board.entity.Member;
import org.example.board.repository.BoardRepository;
import org.example.board.repository.MemberRepository;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardService {

	private final MemberRepository memberRepository;
	private final BoardRepository boardRepository;

	public BoardResponseDto save(String title, String contents, String username) {
		Member findMember = memberRepository.findMemberByUsernameOrElseThrow(username);
		Board board = new Board(title, contents);
		board.setMember(findMember);
		Board savedBoard = boardRepository.save(board); // save()는 이미 인터페이스에서 @Transactional이 선언되어 있다.
		return new BoardResponseDto(savedBoard.getId(), savedBoard.getTitle(), savedBoard.getContents());
	}

	public List<BoardResponseDto> findAll() {
		return boardRepository.findAll()
				.stream()
				.map(BoardResponseDto::toDto)
				.toList();
	}

	public BoardWithAgeResponseDto findById(Long id) {
		Board findBoard = boardRepository.findByIdOrElseThrow(id);
		Member writer = findBoard.getMember();
		return new BoardWithAgeResponseDto(findBoard.getTitle(), findBoard.getContents(), writer.getAge());
	}

	public void delete(Long id) {
		Board findBoard = boardRepository.findByIdOrElseThrow(id);
		boardRepository.delete(findBoard);
	}
}
