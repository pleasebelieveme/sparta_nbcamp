package chapter2.staticexample;

public class Person {
	// static 변수
	static int population = 0;

	// 생성자
	Person () {
		population++;
	}

	// static 메서드
	static void printpopulation() {
		System.out.println("현재 인구 수: " + population);
	}

	// 인스턴스 변수
	String name;

	// 인스턴스 메서드
	void printName() {
		System.out.println("나의 이름은 " + this.name + "입니다.");
	}
}
