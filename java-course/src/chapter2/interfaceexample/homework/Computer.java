package chapter2.interfaceexample.homework;

public class Computer implements Appliance {
	@Override
	public void turnOn() {
		System.out.println("Computer를 켭니다.");
	}

	@Override
	public void turnOff() {
		System.out.println("Computer를 끕니다.");
	}

	public void breakDown() {
		System.out.println("Computer를 부숩니다.");
	}
}
