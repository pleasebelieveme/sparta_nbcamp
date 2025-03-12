package assignment.kiosk.level5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 메서드 묶기 네이밍이 가장 중요!
// 해당 메서드가 많아지면 클래스를 고려
// 해당 메서드가

public class Kiosk {

	private List<Menu> menus;

	Kiosk() {
		this.menus = new ArrayList<>();
		menus.add(new Menu("burger"));
		menus.add(new Menu("drink"));
		menus.add(new Menu("dessert"));
	}

	// `main` 함수에서 관리하던 입력과 반복문 로직은 이제 `start` 함수를 만들어 관리합니다.
	public void start() {
		// Scanner 선언
		Scanner sc = new Scanner(System.in);
		boolean flag = true;

		// 메뉴 객체 생성
		while (flag) {
			System.out.println("\uD83E\uDD17 키오스크를 시작합니다. \uD83E\uDD17");
			System.out.println("[ 메뉴 ]");
			for (int i = 0; i < menus.size(); i++) {
				System.out.println((i+1) + ". " + menus.get(i).getCategory());
			}
			System.out.println("0. 종료");

			// 사용자 입력 숫자 검증
			if (!sc.hasNextInt()) {
				System.out.println("잘못된 입력입니다. 숫자를 입력해주세요.\n");
				sc.next();
				continue;
			}

			// 사용자 입력 저장
			int categoryChoice = sc.nextInt();

			// 카테고리 번호 범위 체크
			if (categoryChoice < 0 || categoryChoice > menus.size()) {
				System.out.println("메뉴에 나와있는 번호를 입력해주세요.\n");
				continue;
			}

			// 카테고리 선택 처리
			if (categoryChoice >= 1 && categoryChoice <= menus.size()) {
				// 메뉴출력
				int idx = 1;
				for (MenuItem m : menus.get(categoryChoice-1).getMenuItems()) {
					System.out.println(idx++ + ". " + m.getName() + "   | W " + m.getPrice() + " | " + m.getDetails());
				}
				System.out.println("0. 뒤로가기\n");

				// 사용자 입력 숫자 검증
				if (!sc.hasNextInt()) {
					System.out.println("잘못된 입력입니다. 숫자를 입력해주세요.\n");
					sc.next();
					continue;
				}

				// 사용자 입력 저장
				int itemChoice = sc.nextInt();

				// 메뉴 번호 범위 체크
				if (itemChoice < 0 || itemChoice > menus.get(categoryChoice-1).getMenuItems().size()) {
					System.out.println("메뉴에 나와있는 번호를 입력해주세요.\n");
					continue;
				}

				// 메뉴 선택 처리
				// 가독성을 높이려고 하다가 더 직관적이지 않은 경우가 생길수 있다.
				if (itemChoice >= 1 && itemChoice <= menus.get(categoryChoice-1).getMenuItems().size()) {
					System.out.println("선택한 메뉴: " + menus.get(categoryChoice-1).getMenuItems().get(itemChoice-1).getName() +
						", 가격: " + menus.get(categoryChoice-1).getMenuItems().get(itemChoice-1).getPrice() +
						", 설명: " + menus.get(categoryChoice-1).getMenuItems().get(itemChoice-1).getDetails() + "\n");
				} else if (itemChoice == 0) {
					continue;
				}
			} else if (categoryChoice == 0) {
				flag = false;
				System.out.println("프로그램을 종료합니다.");
			}
		} // while
		sc.close();
	}
}
