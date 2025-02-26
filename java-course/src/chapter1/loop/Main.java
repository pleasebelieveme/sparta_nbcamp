package chapter1.loop;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// 10번 인사시키기
		System.out.println("안녕하세요.");
		System.out.println("안녕하세요.");
		System.out.println("안녕하세요.");
		System.out.println("안녕하세요.");
		System.out.println("안녕하세요.");
		System.out.println("안녕하세요.");
		System.out.println("안녕하세요.");
		System.out.println("안녕하세요.");
		System.out.println("안녕하세요.");
		System.out.println("안녕하세요.");
		for (int i = 0; i < 10 ; i++) {
			if(i==4) {
				break; // 탈출버튼
			}
			if(i==2) {
				continue;
			}
			System.out.println(i + "번째 손님, 안녕하세요.");
		}

		// // while
		// int i = 1;
		// while (i<=10) {
		// 	System.out.println("안녕하세요!");
		// 	i++;
		// }
		//
		// // do-while
		// int i = 1;
		// do {
		// 	System.out.println("안녕하세요!");
		// 	i++;
		// } while (i<=10);


		// 퀴즈
		System.out.println("출력할 구구단 수를 입력하세요 (2~9): ");
		Scanner sc = new Scanner(System.in);
		int gugudan = sc.nextInt();
		System.out.println("====" + gugudan + "단 ====");
		for (int i = 1; i < 10; i++) {
			System.out.println(gugudan + " X " + i + " = " + gugudan*i);
		}

		// 구구단 모두 출력
		for (int i = 2; i < 10; i++) {
			System.out.println("====" + i + "단 ====");
			for (int j = 1; j < 10; j++) {
				System.out.println(i + " X " + j + " = " + i*j);
			}
		}
	}
}
