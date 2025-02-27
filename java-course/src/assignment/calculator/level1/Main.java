package assignment.calculator.level1;

import java.util.Scanner;

import assignment.calculator.ui.Display;

public class Main {
	public static void main(String[] args) {
			// 계산기 화면
			Display display = new Display();
			display.ui();
			display.menu();

		while (true) {
			// 메뉴입력
			Scanner sc = new Scanner(System.in);
			int menu = sc.nextInt();
			switch (menu) {
				case 1 -> {
					break;
				}
				case 0 -> System.exit(0);
			}

			// 양의 정수(0 포함)를 입력받기
			System.out.print("첫번째 숫자를 입력하세요: ");
			int firstNum = sc.nextInt();
			System.out.print("두번째 숫자를 입력하세요: ");
			int secondNum = sc.nextInt();

			// 개행 문자 제거
			sc.nextLine();

			// 사칙연산 기호(➕,➖,✖️,➗)를 입력받기
			System.out.print("사칙연산 기호를 입력하세요(+, -, *, /): ");
			String operator = sc.next();

			// 위에서 입력받은 양의 정수 2개와 사칙연산 기호를 사용하여 연산을 진행한 후 결과값을 출력하기
			// int result = Integer.MIN_VALUE;
			Integer result = null;

			switch (operator) {
				case "+" -> result = firstNum + secondNum;
				case "-" -> result = firstNum - secondNum;
				case "*" -> result = firstNum * secondNum;
				case "/" -> {
					if(secondNum == 0) {
						System.out.println("0으로 나누어 질 수 없습니다.\n");
						display.menu();
						continue;
					}
					result = firstNum / secondNum;
				}
				default -> {
					System.out.println("올바른 접근이 아닙니다.\n");
					display.menu();
					continue;
				}
			}

			// 2초뒤에 응답
			try {
				System.out.println("계산중...");
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				System.out.println("시스템 오류발생!");
				throw new RuntimeException(e);
			}
			System.out.println("결과: " + firstNum + " " + operator + " " + secondNum + " = " + result + "\n");

			display.ui();
			display.menu();
		}

		// 반복문을 사용하되, 반복의 종료를 알려주는 “exit” 문자열을 입력하기 전까지 무한으로 계산을 진행할 수 있도록 소스 코드를 수정하기
	}
}
