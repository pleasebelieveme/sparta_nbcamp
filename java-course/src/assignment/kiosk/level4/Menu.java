package assignment.kiosk.level4;

import java.util.ArrayList;
import java.util.List;

public class Menu {
	// 카테고리 이름 필드 추가
	private String category;

	// MenuItem 클래스를 List로 관리
	private List<MenuItem> menuItems;

	Menu(String category) {
		this.menuItems = new ArrayList<>();

		this.menuItems.add(new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
		this.menuItems.add(new MenuItem("SmokeBurger", 8.9, "베이컨, 체리 페어에 쉑소스가 토핑된 치즈버거"));
		this.menuItems.add(new MenuItem("CheeseBurger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
		this.menuItems.add(new MenuItem("HamBurger", 5.4, "비프패티를 기반으로 야채가 들어간 치즈버거"));
	}

	// List에 포함된 MenuItem을 순차적으로 보여주는 함수
	public List<MenuItem> showMenu (List<MenuItem> menuItems) {

	// List를 리턴하는 함수
		return menuItems;
	}

	// 구조에 맞게 함수를 선언해놓고 가져다 사용하세요.
}
