package chapter2.clazz;

public class Main {
	public static void main(String[] args) {
		// 객체 생성(인스턴스화)
		Person personA = new Person("K", 35, "서울");

		// 속성 직접 접근
		// System.out.println("설정 전 personA의 이름: " + personA.name);
		// personA.name = "K";
		// System.out.println("설정 후 personA의 이름: " + personA.name);

		// 기능활용
		personA.sum(1, 2);

		// 게터활용
		String result = personA.getName();
		System.out.println("result = " + result);

		// 세터활용
		personA.setName("L");
		System.out.println(personA.name);


		// 숙제 Car클래스를 만들고 drive() 주행기능, accelerate() 가속기능 설정
		Car tico = new Car();
		tico.setDrive(true);
		tico.setAccelerate(true);
		System.out.println(tico.getDrive());
		System.out.println(tico.getAccelerate());


	}
}
