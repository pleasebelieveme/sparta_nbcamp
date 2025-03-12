package assignment.kiosk.challenge1;

public class MenuItem {
	private String name; // 이름
	private double price; // 가격
	private String details; // 세부사항

	MenuItem() {}
	public MenuItem(String name, double price, String details) {
		this.name = name;
		this.price = price;
		this.details = details;
	}

	public String getName() {
		return name;
	}

	//밸리데이션(검증)을 추가하는게 캡슐화의 2단계
	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}
}
