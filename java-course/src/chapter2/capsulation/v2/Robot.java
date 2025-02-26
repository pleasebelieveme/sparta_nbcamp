package chapter2.capsulation.v2;

public class Robot {
	// 로보트가 걷게 만들자
	private boolean leftLeg;
	private boolean rightLeg;
	private boolean leftArm;
	private boolean rightArm;

	// 무분별한 세터
	// public void setLeftLeg(boolean leftLeg) {
	// 	this.leftLeg = leftLeg;
	// }
	//
	// public void setRightLeg(boolean rightLeg) {
	// 	this.rightLeg = rightLeg;
	// }
	//
	// public void setLeftArm(boolean leftArm) {
	// 	this.leftArm = leftArm;
	// }
	//
	// public boolean setRightArm(boolean rightArm) {
	// 	return rightArm;
	// }

	// 의미있는 세터
	public void work(boolean power) {
		this.leftLeg = power;
		this.rightArm = power;
		this.rightLeg = power;
		this.leftArm = power;
	}


}

