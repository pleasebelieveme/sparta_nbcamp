package chapter2.wrapper;

public class CustomInteger {
	// 1. 속성
	int value;
	// 2. 생성자
	CustomInteger () {}
	CustomInteger(int value) {
		this.value = value;
	}
	// 3. 기능 - 자동으로 문자열로 변환해주는 기능
	@Override
	public String toString() {
		return String.valueOf(value);
	}
}
