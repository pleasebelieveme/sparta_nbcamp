package org.example.board.repository;

import java.util.Optional;

import org.example.board.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

	Optional<Member> findMemberByUsername(String username);

	default Member findMemberByUsernameOrElseThrow(String username) {
		return findMemberByUsername(username).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exist username = " + username));
	}

	default Member findByIdOrElseThrow(Long id) {
		return findById(id)
			.orElseThrow(() ->
				new ResponseStatusException(
					HttpStatus.NOT_FOUND, "Does not exist id = " + id
				));
	}

}
