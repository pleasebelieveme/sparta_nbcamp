package chapter1.variable;

public class Main {
	public static void main(String[] args) {
		// [자료형][변수이름]
		// 정수형 21억
		int a;
		a=1;
		a=2;
		System.out.println("a = " + a);

		// 논리형
		boolean booleanBox = true;
		booleanBox = false;
		System.out.println("booleanBox = " + booleanBox);

		// 문자형
		char charBox = 'a';
		charBox = 'b';
		System.out.println("charBox = " + charBox);

		// 큰 정수형 900경
		long longBox = 1;
		longBox = 2;
		System.out.println("longBox = " + longBox);

		// 소수 floast(6~7자리까지), double(15~17) IEEE754부동소수점 표현 방식
		float floatBox = 0.12345678f;
		floatBox = 0.123456789f; // 9를 반올
		System.out.println("floatBox = " + floatBox);
		
		double doubleBox = 0.1234567890;
		System.out.println("doubleBox = " + doubleBox);

		// casting
		// 다운캐스팅
		double bigBox = 10.123; // 뒷자리 손실
		int smallbox = (int) bigBox;
		System.out.println("smallbox = " + smallbox);
		
		// 업캐스팅
		int smallbox2 = 10;
		double bigBox2 = smallbox2;
		System.out.println("bigBox2 = " + bigBox2);

		// 문자열 데이터 '', "" 구분하기
		char a1 = 'a';
		String str = "안녕하세요!";

	}
}
