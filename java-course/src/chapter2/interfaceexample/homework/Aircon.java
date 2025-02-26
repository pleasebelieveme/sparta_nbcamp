package chapter2.interfaceexample.homework;

public class Aircon implements Appliance {
	@Override
	public void turnOn() {
		System.out.println("Aircon을 켭니다.");
	}

	@Override
	public void turnOff() {
		System.out.println("Aircon을 끕니다.");
	}

	public void checkPay() {
		System.out.println("Aircon 비용을 점검합니다.");
	}
}
