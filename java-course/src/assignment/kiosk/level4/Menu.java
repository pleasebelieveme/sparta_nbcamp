package assignment.kiosk.level4;

import java.util.ArrayList;
import java.util.List;

/**
 * MenuItem 클래스를 관리하는 클래스
 */
public class Menu {
	private List<MenuItem> items;  // 메뉴 저장하는

	public Menu() {
		this.items = new ArrayList<>();

		// 테스트 아이템, 메서드 구현 후 테스트는 메인에서
		MenuItem shackBurger = new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거");
		items.add(shackBurger);
	}
}
