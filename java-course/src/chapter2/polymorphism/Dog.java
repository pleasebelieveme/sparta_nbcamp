package chapter2.polymorphism;

public class Dog implements Animal {
	public void wag() {
		System.out.println("꼬리흔들기");
	}

	@Override
	public void makeSound() {
		System.out.println("멍멍!!");
	}

	@Override
	public void exist() {
		System.out.println("강아지가 존재합니다.");
	}
}
