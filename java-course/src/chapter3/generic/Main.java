package chapter3.generic;

public class Main {
	public static <T> void main(String[] args) {
		// 제네릭
		// 1. 재사용 불가
		Box box1 = new Box(100);
		// Integer타입이라서 다른 타입으로 생성자를 만들 수 없음 new Box("ABC");

		// 2. 낮은 타입 안정성
		ObjectBox strBox = new ObjectBox("ABC");
		ObjectBox intBox = new ObjectBox(100);

		// item을 활용하기 위해서는 다운캐스팅 필요
		// Object item = strBox.getItem();
		String item = (String) strBox.getItem();
		System.out.println("item = " + item);
		// 컴파일러가 에러를 못잡음
		// String item2 = (String) intBox.getItem();// ClassCastException


		// 제네릭 활용 (타입소거: T -> Object)
		// 1. 재사용성 보장
		GenericBox<String> strGBox = new GenericBox<>("ABC");
		GenericBox<Integer> intGBox = new GenericBox<>(100);
		GenericBox<Double> doubleGBox = new GenericBox<>(10.214);

		// 2. 타입 안정성 보장(타임소거: 컴파일러가 자동으로 다운캐스팅 삽입)
		String strGBoxItem = strGBox.getItem();
		System.out.println("strGBoxItem = " + strGBoxItem); // 컴파일러가 자동으로 다운캐스팅을 진행
		Integer intGBoxItem = intGBox.getItem();
		System.out.println("intGBoxItem = " + intGBoxItem);
		Double doubleGBoxItem = doubleGBox.getItem();
		System.out.println("doubleGBoxItem = " + doubleGBoxItem);

		// 일반 메서드(String 기준으로 타입소거 발생)
		strGBox.printNormalBoxItem("ABC");
		// strGBox.printNormalBoxItem(100); // 이미 String, error

		// 제너릭 메서드(String과 상관없음, Object타입으로 변환)
		strGBox.printGenericBoxItem("ABC");
		strGBox.printGenericBoxItem(100);
	}
}
