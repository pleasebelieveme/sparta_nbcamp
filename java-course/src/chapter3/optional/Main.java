package chapter3.optional;

import java.util.Optional;

// Optional - null을 안전하게 처리하기 위해서 활용되는 객체
public class Main {
	public static void main(String[] args) {
		Camp camp = new Camp();
		Student K = new Student("K");
		camp.setStudent(K);

		// Optional 객체 활용 -> 반환 데이터 타입으로 null을 조심해달라는 메세지를 줄 수 있다.
		Optional<Student> studentOptional = camp.getStudent();
		boolean flag = studentOptional.isPresent();

		if(flag) {
			Student student = studentOptional.get();
			String studentName = student.getName();
			System.out.println("studentName = " + studentName);
		} else {
			System.out.println("학생 데이터가 없습니다.");
		}

		// // 1. student = null
		// Student student = camp.getStudent();
		// System.out.println("student = " + student);
		// // 직접적인 null 처리 방법
		// String studentName;
		// if (student != null) {
		// 	studentName = student.getName();
		// } else {
		// 	studentName = "등록된 학생이 아닙니다.";
		// }
		// System.out.println("studentName = " + studentName);


		// 2. NullPointException -> 언체크 예외
		// String studentName = student.getName();
		// System.out.println("studentName = " + studentName);
	}
}
