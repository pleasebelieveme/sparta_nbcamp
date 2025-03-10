package assignment.kiosk.level3;

public class MenuItem {
	private String name; // 햄버거 이름
	private double price; // 햄버거 가격
	private String details; // 햄버거 세부사항

	MenuItem() {}
	public MenuItem(String name, double price, String details) {
		this.name = name;
		this.price = price;
		this.details = details;
	}

	public String getName() {
		return name;
	}

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
