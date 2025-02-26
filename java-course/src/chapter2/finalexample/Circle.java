package chapter2.finalexample;

public class Circle {
	// 속성
	static final double PI = 3.14159;
	final double radius;

	// 생성자
	// radius가 이미 초기화가 진행되어서 기본생성자로 인해 초기화가 불가능.
	// Circle() {}
	Circle(double radius) {
		this.radius = radius;
	}

	// 기능
	Circle changeRadius(double newRadius) {
		return new Circle(newRadius);
	}
}
