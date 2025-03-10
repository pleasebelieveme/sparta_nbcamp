package assignment.kiosk.level3;

import java.util.List;

/**
 * 키오스크 프로그램의 메뉴를 관리하고 사용자 입력을 처리하는 클래스
 * - [ ]
 * - [ ]
 * - [ ]
 */

public class Kiosk {

	MenuItem menuItem;
	// `MenuItem`을 관리하는 리스트가 필드로 존재합니다.
	private List<MenuItem> menuItems;

	Kiosk() {}
	Kiosk(List<MenuItem> menuItems) {
		this.menuItems = menuItems;
	}


	// `main` 함수에서 관리하던 입력과 반복문 로직은 이제 `start` 함수를 만들어 관리합니다.
	public void start() {

	}
}
