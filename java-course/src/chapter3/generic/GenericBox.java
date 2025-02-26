package chapter3.generic;

public class GenericBox<T> {
	// 속성
	// 컴파일 시 타입 소거가 이루어져 T -> Object로 치환
	private T item;
	// 생성자
	public GenericBox(T item) {
		this.item = item;
	}
	// 기능

	public T getItem() {
		return item;
	}

	// 일반 메서드
	public void printNormalBoxItem(T item) {
		System.out.println("item = " + item);
	}
	// 제너릭 메서드
	public <S> void printGenericBoxItem(S item) {
		System.out.println("item = " + item);
	}
}
