package chapter2.staticexample;



public class Main {
	public static void main(String[] args) {
		// static 변수, 메서드 활용
		// 클래스 멤버 -> static이 붙은 멤버를 보통 클래스 멤버라고 한다.
		System.out.println("static 변수 활용: " + Person.population);
		Person.printpopulation();

		// 인스턴스 멤버 활용
		Person p1 = new Person();
		Person p2 = new Person();

		// 인스턴스 변수 활용
		p1.name = "K";
		p2.name = "P";

		// 인스턴스 메서드 활용
		p1.printName();
		p2.printName();

		Person.printpopulation();
	}
}
