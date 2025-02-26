package chapter3.Lambda;

public class Main {
	public static void main(String[] args) {
		// 인터페이스를 활용한 익명클래스 만들기
		Calculator calculator1 = new Calculator() {

			@Override
			public int sum(int a, int b) {
				return a + b;
			}
		};
		int ret1 = calculator1.sum(1, 2);
		System.out.println("ret1 = " + ret1);

		// 람다 -> 익명클래스를 간단하게 표현하는 문법
		// 인터페이스를 활용한 람다식 만들기
		Calculator calculator2 = (a, b) -> a + b;
		int ret2 = calculator2.sum(1, 2);
		System.out.println("ret2 = " + ret2);

		// 람다식을 매개변수로 전달하는 방법
		// 1. 익명클래스를 변수에 담아 매개변수로 전달
		Calculator cal1 = new Calculator() {
			@Override
			public int sum(int a, int b) {
				return a + b;
			}
		};
		int ret3 = calculate(1, 2, cal1);
		System.out.println("ret3 = " + ret3);

		// 2. 람다식을 변수에 담아 매개변수로 전달
		Calculator cal2 = (a, b) -> a + b;
		int ret4 = calculate(2, 3, cal2);
		System.out.println("ret4 = " + ret4);

		// 3. 람다식을 직접 매개변수로 전달
		int ret5 = calculate(3, 4, (a, b) -> a + b);
		System.out.println("ret5 = " + ret5);

	}

	public static int calculate(int a, int b, Calculator calculator) {
		return calculator.sum(a, b);
	}
}
