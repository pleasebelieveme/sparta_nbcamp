package assignment.calculator.level2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import assignment.calculator.ui.Display2;

public class Menu {
	Scanner sc = new Scanner(System.in);
	Display2 display = new Display2();
	Calculator calculator;

	public Menu(Calculator calculator) {
		this.calculator = calculator;
	}
	public void selectMenu() {
		int choice = -1;
		boolean flag = true;
		while (flag) {
			if (sc.hasNextInt() || choice == 1 || choice == 2 || choice == 3 || choice == 0) {
				choice = sc.nextInt();
			} else {
				System.out.println("숫자만 입력이 가능합니다.\n");
				sc.next();
				display.menu();
				continue;
			}

			switch (choice) {
				case 1 -> {
					display.askFirstNum();
					calculator.setFirstNum(sc.nextInt());
					display.askSecondtNum();
					calculator.setSecondNum(sc.nextInt());
					display.askOperator();
					calculator.setOperator(sc.next());
					flag = false;
				}
				case 2 -> {
					List<Integer> resultArray = calculator.getResultArray();
					if (resultArray.isEmpty()) {
						System.out.println("계산된 결과가 없습니다. 먼저 계산을 진행해주세요.");
					} else {
						display.printResult(resultArray);
					}
					flag = false;
				}
				case 3 -> {
					calculator.setFirstNum(0);
					calculator.setSecondNum(0);
					calculator.setOperator("");
					calculator.setResultArray(new ArrayList<>());
					System.out.println("계산값이 초기화 되었습니다.");
					flag = false;
				}
				case 0 -> {
					flag = false;
					System.exit(0);
				}
				default -> {
					System.out.println("메뉴를 다시 입력해주세요.\n");
					display.menu();
					continue;
				}
			}
		}
	}
	public void printRestart() {
		System.out.println("다시 하시겠습니까? (Y/N)");
		String choice = sc.next();
		if(choice.equalsIgnoreCase("y")) {}
		else System.exit(0);
	}
}
