package chapter2.interitance;

public class Parent {
	public String familyName = "스파르탄";
	public int honor = 10;

	Parent() {
		System.out.println("부모생성자");
	}

	public void introduceFamily() {
		System.out.println("우리 " + familyName + "은 대대로...");
	}
}
