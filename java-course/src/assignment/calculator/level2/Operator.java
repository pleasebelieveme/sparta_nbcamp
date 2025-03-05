package assignment.calculator.level2;

import java.util.ArrayList;
import java.util.List;

public class Operator {
	// 기능
	public int calculate(int firstNum, int secondNum, String operator) {
		int result = 0;
		Calculator calculator = Calculator.getInstance();
		switch (operator) {
			case "+": {
				result = (sum(firstNum, secondNum));
				break;
			}
			case "-": {
				result = (sub(firstNum, secondNum));
				break;
			}
			case "*": {
				result = (mul(firstNum, secondNum));
				break;
			}
			case "/": {
				if(secondNum==0) {
					System.out.println("0으로 나눌 수 없습니다.");
					break;
				}
				result = (div(firstNum, secondNum));
				break;
			}
		}
		System.out.println();
		return result;
	}
	public int sum(int firstNum, int secondNum) {
		int result = firstNum + secondNum;
		return result;
	}

	public int sub(int firstNum, int secondNum) {
		int result = firstNum - secondNum;
		return result;
	}

	public int mul(int firstNum, int secondNum) {
		int result = firstNum * secondNum;
		return result;
	}

	public int div(int firstNum, int secondNum) {
		int result = firstNum / secondNum;
		return result;
	}
}
