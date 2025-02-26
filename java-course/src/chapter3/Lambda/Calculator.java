package chapter3.Lambda;

// 함수형 인터페이스 -> 추상메서드가 1개만 존재, 2개가 넘어가면 import할때 자바가 헷갈려 함
@FunctionalInterface
public interface Calculator {
	int sum(int a, int b);
}
