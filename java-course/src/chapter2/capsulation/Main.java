package chapter2.capsulation;

public class Main {
	public static void main(String[] args) {
		// 생성자 호출 때 접근제어자의 역할
		Person person = new Person();
		// public 접근가능, private 접근 불가
		// 인스턴스 변수가 private면 접근 불가
		person.name = "K";
		// 인스턴스 메서드도 마찬가지

		// 게터
		String name = person.getName();
		System.out.println("이름: " + name);

		// 세터
		person.setName("P");
		name = person.getName();
		System.out.println("이름: " + name);

	}
}
