package assignment.calculator.level2;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

	// 속성
	private static Calculator instance;
	private List<Integer> resultArray;
	private int firstNum;
	private int secondNum;
	private String operator = "";

	// 생성자

	private Calculator() {
		this.resultArray = new ArrayList<>();
	}

	public static Calculator getInstance() {
		if (instance == null) {
			instance = new Calculator();
		}
		return instance;
	}
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

	public void setResultArray(List<Integer> resultArray) {
		this.resultArray = resultArray;
	}
	public List<Integer> calculate(int firstNum, int secondNum, String operator) {
		Operator calculate = new Operator();
		int result = calculate.calculate(firstNum, secondNum, operator);
		resultArray.add(result);
		return resultArray;
	}
}
