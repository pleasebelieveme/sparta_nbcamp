package assignment.kiosk.level3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Kiosk {

	// MenuItem menuItem;
	// `MenuItem`을 관리하는 리스트가 필드로 존재합니다.
	private List<MenuItem> menuItems;


	Kiosk() {
		this.menuItems = new ArrayList<>();

		this.menuItems.add(new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
		this.menuItems.add(new MenuItem("SmokeBurger", 8.9, "베이컨, 체리 페어에 쉑소스가 토핑된 치즈버거"));
		this.menuItems.add(new MenuItem("CheeseBurger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
		this.menuItems.add(new MenuItem("HamBurger", 5.4, "비프패티를 기반으로 야채가 들어간 치즈버거"));
	}

	// `main` 함수에서 관리하던 입력과 반복문 로직은 이제 `start` 함수를 만들어 관리합니다.
	public void start() {


		// Scanner 선언
		Scanner sc = new Scanner(System.in);
		boolean flag = true;

		while (flag) {
			System.out.println("\uD83E\uDD17 키오스크를 시작합니다. \uD83E\uDD17");
			// 메뉴출력
			int idx = 1;
			for (MenuItem m : menuItems) {
				System.out.println(idx++ + ". " + m.getName() + "   | W " + m.getPrice() + " | " + m.getDetails());
			}

			// 사용자 입력 숫자 검증
			if (!sc.hasNextInt()) {
				System.out.println("잘못된 입력입니다. 숫자를 입력해주세요.\n");
				sc.next();
				continue;
			}

			// 사용자 입력 저장
			int choice = sc.nextInt();

			// 메뉴 번호 범위 체크
			if (choice < 0 || choice > 4) {
				System.out.println("메뉴에 나와있는 번호를 입력해주세요.\n");
				continue;
			}

			// 메뉴 선택 처리
			// 스위치없이 출력을 한줄로
			//  값이 추가되거나 삭제되었을때 방안 고민
			switch (choice) {
				case 1:
				case 2:
				case 3:
				case 4:
					System.out.println("선택한 메뉴: " + menuItems.get(choice-1).getName() + ", 가격: " + menuItems.get(choice-1).getPrice() + ", 설명: " + menuItems.get(choice-1).getDetails()+ "\n");
					break;
				case 0:
					flag = false;
					System.out.println("프로그램을 종료합니다.");
					break;
			} // switch
		} // while
		sc.close();
	}
}
