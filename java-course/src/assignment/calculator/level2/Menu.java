package assignment.calculator.level2;

import java.util.Scanner;

public class Menu {
	Scanner sc = new Scanner(System.in);
	public void selectMenu() {
		int choice = -1;
		boolean flag = true;
		while (flag) {
			if (sc.hasNextInt() || choice == 1 || choice == 0) {
				choice = sc.nextInt();
			} else {
				System.out.println("숫자만 입력이 가능합니다.\n");
				sc.next();
				System.out.println("메뉴를 입력하세요: ");
				System.out.println("1. 두개의 숫자로 사칙연산하기");
				System.out.println("0. 종료하기");
				continue;
			}

			switch (choice) {
				case 1 -> flag = false;
				case 0 -> {
					flag = false;
					System.exit(0);
				}
				default -> {
					System.out.println("메뉴를 다시 입력해주세요.\n");
					System.out.println("메뉴를 입력하세요: ");
					System.out.println("1. 두개의 숫자로 사칙연산하기");
					System.out.println("0. 종료하기");
					continue;
				}
			}
		}
	}
}
