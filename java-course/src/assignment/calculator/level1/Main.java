package assignment.calculator.level1;

import java.util.Scanner;

import assignment.calculator.ui.Display;

/**
 * 계산기 과제
 * 1. do-while문 고민해보기
 * 2. 결과값을 검증하는게 아니라 계산과정을 검증
 * 3. while문을 사용할 때 flag사용
 */
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean flag = true;

		// 계산기 화면
		Display display = new Display();
		display.ui();

		// 제어문 고민, 경우 1. do-while
		while (flag) {
			display.menu();
			// System.out.print("\033[H\033[2J"); // ANSI 코드 (화면 지우기)
			// System.out.flush(); // 버퍼 비우기

			// 메뉴입력
			// 입력값 예외처리 -> 중복코드 해결 방법 고민
			int menu = -1;
			while (true) {
				if (sc.hasNextInt() || menu == 1 || menu == 0) {
					menu = sc.nextInt();
					break;
				} else {
					System.out.println("숫자만 입력이 가능합니다.\n");
					// 잘못된 입력값 제거
					sc.next();
					display.menu();
					continue;
				}
			}
			switch (menu) {
				case 1 -> {}
				case 0 -> {
					flag = false;
					System.exit(0);
				}
				default -> {
					System.out.println("메뉴를 다시 입력해주세요.\n");
					continue;
				}
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

			// 값으로 검증하는게 아니라 계산을 검증해야 한다.
			// int result = Integer.MIN_VALUE;

			// null처리 필요
			// Integer result = null;
			int result = 0;

			switch (operator) {
				case "+" -> result = firstNum + secondNum;
				case "-" -> result = firstNum - secondNum;
				case "*" -> result = firstNum * secondNum;
				case "/" -> {
					if(secondNum == 0) {
						System.out.println("0으로 나누어 질 수 없습니다.\n");
						// while문 처음으로
						continue;
					}
					result = firstNum / secondNum;
				}
				default -> {
					System.out.println("+, -, *, / 중 하나를 입력하세요.\n");
					display.menu();
					continue;
				}
			}

			// 2초뒤에 응답, 연산결과시간에 따라 적용, 불필요한 쓰레드의 점유
			// try {
			// 	System.out.println("계산중...");
			// 	Thread.sleep(2000);
			// } catch (InterruptedException e) {
			// 	System.out.println("시스템 오류발생!");
			// 	throw new RuntimeException(e);
			// }
			System.out.println("결과: " + firstNum + " " + operator + " " + secondNum + " = " + result + "\n");
			// for (int i = 0; i < 30; i++) {
			// 	System.out.println();
			// }
			display.ui();
		}
		// 반복문을 사용하되, 반복의 종료를 알려주는 “exit” 문자열을 입력하기 전까지 무한으로 계산을 진행할 수 있도록 소스 코드를 수정하기
	}
}
