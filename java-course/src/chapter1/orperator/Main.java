package chapter1.orperator;

public class Main {
	public static void main(String[] args) {
		int a = 10;
		int b = 3;

		// 기본적인 사칙연산
		int sum = a+b;
		System.out.println("sum = " + sum);

		int sub = a-b;
		System.out.println("sub = " + sub);
		
		int mul = a*b;
		System.out.println("mul = " + mul);

		// 나눗셈
		int div = a/b;

		// a/3.0
		double div2 = a/3.0;
		System.out.println("div2 = " + div2);

		// 모듈러 연산 %
		int mod = 10 % 3;
		System.out.println("mod = " + mod);

		// 활용 -> 시간 지금 10신데 5시간 뒤는 몇시에요?, 짝수확인
		int mod2 = (10 + 1) / 12;
		System.out.println("mod2 = " + mod2);

		// 대입연산자
		int num = 5;
		// 복합대입연산자 +, -, *, /, %
		num += 3;
		System.out.println("num = " + num);
		
		// 증감연산자
		num = 1;
		num++;
		num++;
		num--;
		num--;
		System.out.println("num = " + num);

		// 전위연(++num) - 연산 후 값이 활용
		int intBox = 5;
		System.out.println("++intBox = " + ++intBox);
		int intBox2 = 5;
		System.out.println("intBox++ = " + intBox2++);
		System.out.println("intBox++ = " + intBox2);

		// 비교연산자
		// 같음연산자(==) 같으면 true, 다르면 false
		System.out.println("10 == 10: " + (10 == 10));

		// 다름연산자(!=)
		System.out.println("10 != 5: " + (10 != 5));

		// 크기비교연산자
		System.out.println("10 < 5: " + (10 < 5));
		System.out.println("10 >= 10: " + (10 >= 10));
		System.out.println("10 <= 5: " + (10 <= 5));

		// 논리연산자
		// AND 연산(&&) - 두 조건이 모두 참일 때 true 반환
		System.out.println("true && true: " + (true&&true));

		// OR 연산(||) - 두 조건 중 하나라도 참 일때 true 반환
		System.out.println("true || false: " + (true||false));

		// NOT 연산자(1)
		System.out.println("!true: " + !true);

		// 연산자 우선순위
		boolean flag = 10 + 5 > 12 && true;
		System.out.println("flag = " + flag);

		// 논리연산자 우선순위(! -> && -> ||)
		boolean result = true || false && false;

		// 문자열 비교 .equals -> 동등성, 동일성 비교
		String text = "hello";
		String text2 = "Hello";
		boolean isEqual = text.equals(text2);
		System.out.println("isEqual = " + isEqual);

	}
}
