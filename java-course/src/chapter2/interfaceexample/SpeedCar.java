package chapter2.interfaceexample;

public class SpeedCar implements Car{
	@Override
	public void drive() {
		System.out.println("빠르게 주행합니다.");
	}

	@Override
	public void stop() {
		System.out.println("빠르게 정지합니다.");
	}
	// void drive() {
	// 	System.out.println("빠르게 주행합니다.");
	// }

	public void autoParking() {
		System.out.println("자동 기능 주차를 실행합니다.");
	}
}
