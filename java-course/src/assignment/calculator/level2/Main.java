package assignment.calculator.level2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import assignment.calculator.ui.Display2;

public class Main {
	public static void main(String[] args) {
		Display2 display = new Display2();
		Calculator calculator = Calculator.getInstance();
		Menu menu = new Menu(calculator);

		List<Integer> resultArray = new ArrayList<>();
		// 화면출력
		display.ui(resultArray);

		// 메뉴선택
		while(true) {
			display.menu();
			menu.selectMenu();
			// 계산하기
			resultArray = calculator.calculate(calculator.getFirstNum(), calculator.getSecondNum(), calculator.getOperator());
			// 결과출력
			display.ui(resultArray);
		}
	}
}
