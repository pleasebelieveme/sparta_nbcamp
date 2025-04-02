package org.example.board.service;

import java.util.Optional;

import org.example.board.dto.MemberResponseDto;
import org.example.board.dto.SignUpResponseDto;
import org.example.board.entity.Member;
import org.example.board.repository.MemberRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberService {

	private final MemberRepository memberRepository;

	public SignUpResponseDto signUp(String username, String password, Integer age) {
		Member member = new Member(username, password, age);
		Member savedMember = memberRepository.save(member);
		return new SignUpResponseDto(savedMember.getId(), savedMember.getUsername(), savedMember.getAge());
	}

	public MemberResponseDto findById(Long id) {
		Optional<Member> optionalMember = memberRepository.findById(id);
		if(optionalMember.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NO_CONTENT, "Does not exists id : " + id); // 요청은 성공했으나 컨텐츠가 없을 때, 통일성이 중요!
		}
		Member findMember = optionalMember.get();
		return new MemberResponseDto(findMember.getUsername(), findMember.getAge());
	}

	@Transactional
	public void updatePassword(Long id, String oldPassword, String newPassword) {
		Member findMember = memberRepository.findByIdOrElseThrow(id);
		if (!findMember.getPassword().equals(oldPassword)) {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "비밀번호가 일치하지 않습니다.");
		}
		findMember.updatePassword(newPassword);
	}
}
