package org.example.board.controller;

import org.example.board.dto.MemberResponseDto;
import org.example.board.dto.SignUpRequestDto;
import org.example.board.dto.SignUpResponseDto;
import org.example.board.dto.UpdatePasswordRequestDto;
import org.example.board.service.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {

	private final MemberService memberService;

	@PostMapping("/signup")
	public ResponseEntity<SignUpResponseDto> signUp(@RequestBody SignUpRequestDto requestDto) {
		SignUpResponseDto signUpResponseDto = memberService.signUp(
			requestDto.getUsername(),
			requestDto.getPassword(),
			requestDto.getAge()
		);
		return new ResponseEntity<>(signUpResponseDto, HttpStatus.CREATED);
	}

	@GetMapping("{id}")
	public ResponseEntity<MemberResponseDto> findById(@PathVariable Long id) {
		MemberResponseDto memberResponseDto = memberService.findById(id);
		return new ResponseEntity<>(memberResponseDto, HttpStatus.OK);
	}

	@PatchMapping("/{id}")
	public ResponseEntity<Void> updatePassword(
		@PathVariable Long id,
		@RequestBody UpdatePasswordRequestDto requestDto
	) {
		memberService.updatePassword(id, requestDto.getOldPassword(), requestDto.getNewPassword());
		return new ResponseEntity<>(HttpStatus.OK);
	}


}
