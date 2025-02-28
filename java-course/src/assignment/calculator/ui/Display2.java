package assignment.calculator.ui;

import java.util.List;
import java.util.Scanner;

public class Display2 {
	Scanner sc = new Scanner(System.in);
	public void ui(List<Integer> result) {
	String resultSpace = "";
		System.out.println("+---------------------------+");
		System.out.println("| ////// Calculator /////// |");
		System.out.println("+---------------------------+");
		if (result != null && !result.isEmpty()) {
			int totalresultSpace = 21;
			int resultLength = String.valueOf(result.get(result.size()-1)).length();
			int resultSpaceLength = totalresultSpace - resultLength;
			for (int i = 0; i < resultSpaceLength ; i++) {
				resultSpace += " ";
			}
			System.out.println("| [ " + resultSpace + result.get(result.size()-1) + " ] |");
		} else {
			System.out.println("| [                     0 ] |");
		}
		System.out.println("+---------------------------+");
		System.out.println("| [ 7 ] [ 8 ] [ 9 ] [  +  ] |");
		System.out.println("| [ 4 ] [ 5 ] [ 6 ] [  -  ] |");
		System.out.println("| [ 1 ] [ 2 ] [ 3 ] [  *  ] |");
		System.out.println("| [ . ] [ 0 ] [ / ] [  =  ] |");
		System.out.println("+---------------------------+");
	}
	public void menu() {
		System.out.println("메뉴를 입력하세요: ");
		System.out.println("1. 두개의 숫자로 사칙연산하기");
		System.out.println("0. 종료하기");
	}
	public void askFirstNum() {
		System.out.println("첫번째 숫자를 입력하세요: ");
	}
	public void askSecondtNum() {
		System.out.println("두번째 숫자를 입력하세요: ");
	}
	public void askOperator() {
		System.out.print("사칙연산 기호를 입력하세요(+, -, *, /): ");
	}
}
