package chapter2.clazz;

public class Car {
	boolean drive;
	boolean accelerate;
	Car () {}
	Car (boolean drive, boolean accelerate) {
		this.drive = drive;
		this.accelerate = accelerate;
	}

	public boolean getDrive() {
		return drive;
	}

	public void setDrive(boolean drive) {
		this.drive = drive;
	}

	public boolean getAccelerate() {
		return accelerate;
	}

	public void setAccelerate(boolean accelerate) {
		this.accelerate = accelerate;
	}
}
