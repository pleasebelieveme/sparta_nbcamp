package assignment.kiosk.challenge1;

import java.util.ArrayList;
import java.util.List;

public class Menu {
	// 카테고리 이름 필드 추가
	private String category;

	// MenuItem 클래스를 List로 관리
	private List<MenuItem> menuItems;

	Menu(String category) {
		this.category = category;
		this.menuItems = initializeMenu(category);
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	// 호출해서 사용할때 주의점
	// 리스트를 복사해서 주면 수정시 영향을 미침 깊은복사, 얉은 복사
	public List<MenuItem> getMenuItems() {
		return menuItems;
	}

	public void setMenuItems(List<MenuItem> menuItems) {
		this.menuItems = menuItems;
	}

	// 메뉴아이템 값 주입
	private List<MenuItem> initializeMenu(String category) {
		// List를 리턴하는 함수
		List<MenuItem> menuItems = new ArrayList<>();
		if (category.equals("burger")) {
			menuItems.add(new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
			menuItems.add(new MenuItem("SmokeBurger", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
			menuItems.add(new MenuItem("CheeseBurger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
			menuItems.add(new MenuItem("HamBurger", 5.4, "비프패티를 기반으로 야채가 들어간 치즈버거"));
		} else if (category.equals("drink")) {
			menuItems.add(new MenuItem("Coke", 2.5, "탄산이 들어간 청량한 음료"));
			menuItems.add(new MenuItem("Lemonade", 3.0, "레몬즙이 들어간 시원한 음료"));
			menuItems.add(new MenuItem("Iced Tea", 3.5, "홍차를 얼음과 함께 시원하게 즐기는 음료"));
			menuItems.add(new MenuItem("Milkshake", 4.5, "바닐라, 초콜릿, 딸기 중 선택 가능한 진한 밀크셰이크"));
		} else if (category.equals("dessert")) {
			menuItems.add(new MenuItem("Ice Cream", 4.0, "부드럽고 달콤한 바닐라 아이스크림"));
			menuItems.add(new MenuItem("Brownie", 3.5, "초콜릿이 가득한 촉촉한 브라우니"));
			menuItems.add(new MenuItem("Cheesecake", 4.5, "부드러운 크림치즈가 올라간 진한 치즈케이크"));
			menuItems.add(new MenuItem("Macaron", 2.8, "겉은 바삭, 속은 쫀득한 다양한 맛의 마카롱"));
		}
		return menuItems;
	}
	// 구조에 맞게 함수를 선언해놓고 가져다 사용하세요.

	// 1. initializeMenu private
	// 2. 메뉴아이템 리스트 복사시 주의점
}
