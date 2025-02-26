package chapter2.abstractexample;

public class Main {
	public static void main(String[] args) {
		// 추상클래스는 인스턴스화 할 수 없다
		// Animal animal = new Animal();
		Cat cat = new Cat();
		cat.name = "bumi";
		cat.sleep();
		// 자식에서 강제 구현된 메소드
		cat.eat();
	}
}
