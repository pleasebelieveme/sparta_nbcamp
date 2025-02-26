package chapter3.exception;

public class Main {
	public static void main(String[] args) throws Exception {
		// 1. 의도하지 않은 예외
		// 0으로 나눌 수 없다
		// int ret = 10/0;
		// System.out.println("ret = " + ret);
		// System.out.println("프로그램 종료");

		// 2. 의도적인 예외 - throw
		// int age = 10;
		// if(age<18) {
		// 	throw new IllegalStateException("미성년자 출입금지!");
		// }
		// System.out.println("프로그램 종료");

		// 3. 언체크 예외 호
		// ExceptionPractice exceptionPractice = new ExceptionPractice();
		// exceptionPractice.callUncheckedException();


		// 여기서 예외 처리
		// ExceptionPractice exceptionPractice = new ExceptionPractice();
		// try {
		// 	exceptionPractice.callUncheckedException();
		// } catch (RuntimeException e) {
		// 	System.out.println("언체크 예외 처리");
		// }
		//
		// System.out.println("프로그램 종료");

		// 4. 체크 예외 호출
		// ExceptionPractice exceptionPractice = new ExceptionPractice();
		// exceptionPractice.callUncheckedException();
		// System.out.println("프로그램 종료");

		// 5. 체크 예외 상단 처리
		ExceptionPractice exceptionPractice = new ExceptionPractice();
		exceptionPractice.callUncheckedException();
		System.out.println("프로그램 종료");

	}
}
