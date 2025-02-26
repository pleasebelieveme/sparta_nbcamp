package chapter1.io;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// println 사용
		System.out.println("Hello");
		System.out.println("Java");

		// print 사용
		System.out.print("안녕");
		System.out.print("자바");

		// 개행문자 사용
		System.out.println("Hello\nJava");


		// 출력
		Scanner sc = new Scanner(System.in);

		// 문자열 입력받기
		System.out.println("좋아하는 문장을 입력하세요: ");
		String sentence = sc.nextLine();
		System.out.println("sentence = " + sentence);

		// 정수형 입력받기
		System.out.println("정수(int)를 입력하세요: ");
		int intBox = sc.nextInt();
		System.out.println("intBox = " + intBox);

		// long
		System.out.println("정수(long)를 입력하세요: ");
		long longBox = sc.nextLong();
		System.out.println("longBox = " + longBox);
		
		// 소수점
		System.out.println("소수를 입력하세요: ");
		Double doubleBox = sc.nextDouble();
		System.out.println("doubleBox = " + doubleBox);
		
		
		// 퀴즈
		System.out.println("이름을 입력하세요: ");
		String name = sc.nextLine();
		System.out.println("나이를 입력하세요: ");
		int age = sc.nextInt();
		System.out.println("출력 결과: ");
		System.out.println("name = " + name);
		System.out.println("age = " + age);
	}
}
