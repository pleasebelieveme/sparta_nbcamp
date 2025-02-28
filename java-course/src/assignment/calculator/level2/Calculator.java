package assignment.calculator.level2;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

	// 송성
	private int firstNum;
	private int secondNum;
	private String operator = "";
	private List<Integer> resultArray;
	// 생성자
	public Calculator () {};
	public Calculator(int firstNum, int secondNum, String operator, List<Integer> resultArray) {
		this.firstNum = firstNum;
		this.secondNum = secondNum;
		this.operator = operator;
		this.resultArray = resultArray;
	}

	public int getFirstNum() {
		return firstNum;
	}

	public void setFirstNum(int firstNum) {
		this.firstNum = firstNum;
	}

	public int getSecondNum() {
		return secondNum;
	}

	public void setSecondNum(int secondNum) {
		this.secondNum = secondNum;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public List<Integer> getResultArray() {
		return resultArray;
	}

	public void setResultArray(ArrayList<Integer> resultArray) {
		this.resultArray = resultArray;
	}
	// 기능

	public List<Integer> operator(int firstNum, int secondNum, String operator) {
		resultArray = new ArrayList<>();
		switch (operator) {
			case "+": {
				resultArray.add(sum(firstNum, secondNum));
				break;
			}
			case "-": {
				resultArray.add(sub(firstNum, secondNum));
				break;
			}
			case "*": {
				resultArray.add(mul(firstNum, secondNum));
				break;
			}
			case "/": {
				if(secondNum==0) {
					System.out.println("0으로 나눌 수 없습니다.");
					break;
				}
				resultArray.add(div(firstNum, secondNum));
				break;
			}
		}
		System.out.println();
		return resultArray;
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
