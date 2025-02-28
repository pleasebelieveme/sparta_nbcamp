package assignment.calculator.level2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import assignment.calculator.ui.Display2;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Display2 display = new Display2();
		Menu menu = new Menu();
		Calculator calculator = new Calculator();

		int index;
		List<Integer> result = new ArrayList<>();

		// 화면출력
		display.ui(result);

		// 메뉴선택
		display.menu();
		do {
			menu.selectMenu();

			// 숫자, 기호입력
			display.askFirstNum();
			calculator.setFirstNum(sc.nextInt());
			display.askSecondtNum();
			calculator.setSecondNum(sc.nextInt());

			display.askOperator();
			calculator.setOperator(sc.next());

			// 계산하기
			result = calculator.operator(calculator.getFirstNum(), calculator.getSecondNum(), calculator.getOperator());

			// 결과출력
			display.ui(result);
			display.menu();
		} while (true);
	}
}
