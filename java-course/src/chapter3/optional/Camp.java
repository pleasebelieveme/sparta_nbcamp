package chapter3.optional;

import java.util.Optional;

public class Camp {
	// 속성
	private Student student;

	// 생성자
	Camp() {}

	// 기능

	public Optional<Student> getStudent() {
		return Optional.ofNullable(student);
		// return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
}
