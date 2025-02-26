package chapter2.capsulation;

public class Person {
	// 송성
	public String name;
	private String secret;

	// 생성자
	Person() {}

	// 기능
	public void methodA () {}
	private void methodB () {}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
