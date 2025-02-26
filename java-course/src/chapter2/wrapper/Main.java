package chapter2.wrapper;


public class Main {
	public static void main(String[] args) {
		// 참조형 변수 -> 객체는 Heap에 저장되고 참조형 변수는 주소값을 저장한다
		Person personA = new Person();
		System.out.println("personA = " + personA);
		
		// 배열도 참조형 변수
		int[] arr = {1, 2, 3};
		System.out.println("arr = " + arr);

		// wrapperClass(기본형 변수를 감싸고 있는 클래스)
		// 참조형 변수
		Integer num = 100;
		System.out.println("num = " + num); // 내부적으로 처리되어(toString()) 주소값이 아닌 값이 나옴

		// 객체처럼 기능을 가지기 위해 래퍼클래스를 사용
		int num2 = 200;
		// String num3 = num2; // error

		Integer num4 = 400;
		System.out.println(num4.toString()); // 문자열로 쉽게 변경가능


		// 직접 만든 래퍼클래스
		CustomInteger myInteger = new CustomInteger(10);
		String myStrInteger = myInteger.toString();
		System.out.println("myStrInteger = " + myStrInteger);

		// 오토박심 (기본형 -> 래퍼형)
		Integer number1 = 10;
		// 내부적으로 생성자 호출
		// Integer number1 = Integer.valueOf(10);

		// 오토 언박싱
		// 참조형을 기본형에 넣는데 에러가 나지 않는다.
		int number2 = number1;
		// int number2 = number1.intValue();



		// 숙제
		// double 기본형과 직접만든 MyDouble 래퍼형의 연산 성능차이 확인하기
		int iteration = 10_000_000; // 1000만 번 반복

		// 기본형 int 연산 성능 테스트
		long startTime1 = System.nanoTime();
		double sum1 = 0.0;
		for (int i = 0; i < iteration; i++) {
			sum1 += i;  // 기본형 연산
		}
		long endTime1 = System.nanoTime();
		long primitiveTime = endTime1 - startTime1;

		// 래퍼 클래스 Integer 연산 성능 테스트
		long startTime2 = System.nanoTime();
		Double sum2 = 0.0;
		for (int i = 0; i < iteration; i++) {
			sum2 += i;  // 오토박싱 & 언박싱 발생
		}
		long endTime2 = System.nanoTime();
		long wrapperTime = endTime2 - startTime2;

		// 결과 출력
		System.out.println("기본형(double) 연산 시간: " + primitiveTime + " ns");
		System.out.println("래퍼 클래스(Double) 연산 시간: " + wrapperTime + " ns");
		System.out.println("성능 차이 (배수): " + (double) wrapperTime / primitiveTime);
	}
}
