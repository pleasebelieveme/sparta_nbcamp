package chapter3.exception;

public class ExceptionPractice {
	// 1. 언체크 예외 호출 예시
	public void callUncheckedException() throws Exception {

		// 여기서 예외 처리
		// try {
		// 	if (true) {
		// 		System.out.println("언체크 예외 발생");
		// 		throw new RuntimeException();
		// 	}
		// } catch (RuntimeException e) {
		// 	System.out.println("언체크 예외 처리");
		// }

		// 메인에서 예외 처리
		// if (true) {
		// 	System.out.println("언체크 예외 발생");
		// 	throw new RuntimeException();
		// }

		// 2. 체크 예외 호출 예시

		// try {
		// 	if(true) {
		// 		System.out.println("체크 예외 발생");
		// 		throw new Exception(); // 컴파일러가 빨간색으로 처리 요구
		// 	}
		// } catch (Exception e) {
		// 	System.out.println("체크 예외 처리");
		// }


		// 상단에서 처리
		if(true) {
			System.out.println("체크 예외 발생");
			throw new Exception(); // 컴파일러가 빨간색으로 처리 요구
		}
	}
}
