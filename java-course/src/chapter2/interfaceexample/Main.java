package chapter2.interfaceexample;

public class Main {
	public static void main(String[] args) {
	LuxuryCar luxuryCar = new LuxuryCar();
	SpeedCar speedCar = new SpeedCar();

	// 활용 기능이 겹치는데 메서드 이름이 다름
	// luxuryCar.move();
	// luxuryCar.stop();
	// speedCar.drive();

		luxuryCar.drive();
		speedCar.drive();
	}
}
