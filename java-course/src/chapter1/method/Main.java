package chapter1.method;

public class Main {
	public static void main(String[] args) {
		// 1. 객체 선언(객체화, 인스턴스화)
		Calculator c = new Calculator();

		// 함수 호
		int a = c.sum(1, 2);
		System.out.println("a = " + a);
		
	}
}
