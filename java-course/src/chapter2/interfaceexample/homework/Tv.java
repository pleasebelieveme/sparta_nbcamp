package chapter2.interfaceexample.homework;

public class Tv implements Appliance {
	@Override
	public void turnOn() {
		System.out.println("Tv를 켭니다.");
	}

	@Override
	public void turnOff() {
		System.out.println("Tv를 끕니다.");
	}

	public void changeChannel() {
		System.out.println("채널을 바꿉니다.");
	}
}
