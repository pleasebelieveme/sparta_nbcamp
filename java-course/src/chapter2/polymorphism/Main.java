package chapter2.polymorphism;

public class Main {
	public static void main(String[] args) {
		// 다형성 활용
		Animal ani1 = new Cat();
		Animal ani2 = new Dog();

		ani1.exist();
		ani1.makeSound();
		ani2.exist();
		ani2.makeSound();

		// 업캐스팅 주의사 - 자식타입의 고유기능을 사용할 수 없다
		// ani1.scratch();
		// ani2.wag();

		// 다운캐스
		Cat cat = (Cat) ani1;
		cat.scratch();

		Dog dog = (Dog) ani2;
		dog.wag();

		// 잘못된 다운캐스팅 문제
		// Cat cat2 = (Cat) ani2; // ani2 = Dog인데 컴파일오류가 발생하지 않는다 -> 실행 시 ClassCastException발생
		// cat2.scratch();

		// 다운캐스팅시 instanceof 활용 방법
		if(ani2 instanceof Cat) {
			Cat cat2 = (Cat) ani2;
			cat2.scratch();
		} else {
			System.out.println("객체가 고양이가 아닙니다.");
		}

		Animal[] animals = {new Cat(), new Dog(), new Cat()};
		System.out.println("::::::::");
		for (Animal a : animals) {
			a.makeSound();
		}
	}
}
