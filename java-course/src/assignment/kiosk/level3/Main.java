package assignment.kiosk.level3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 *
 *
 *
 *
 *
 *
 * 		// 입력된 숫자에 따른 처리
 * 		// 프로그램을 종료
 * 		// 선택한 메뉴 : 이름, 가격, 설명 등을 출력
 */
public class Main {
	public static void main(String[] args) {

		Kiosk kiosk = new Kiosk();
		kiosk.start();






		// List 선언 및 초기화
		List<MenuItem> itemList = new ArrayList<>();
		// add 함수를 통해 new MenuItem(이름, 가격, 설명) itemList에 삽입
		itemList.add(new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
		itemList.add(new MenuItem("SmokeBurger", 8.9, "베이컨, 체리 페어에 쉑소스가 토핑된 치즈버거"));
		itemList.add(new MenuItem("CheeseBurger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
		itemList.add(new MenuItem("HamBurger", 5.4, "비프패티를 기반으로 야채가 들어간 치즈버거"));

		// 메뉴출력
		// Scanner 선언
		Scanner sc = new Scanner(System.in);
		boolean flag = true;

		while (flag) {
			System.out.println("\uD83E\uDD17 키오스크를 시작합니다. \uD83E\uDD17");
			int idx = 1;
			for (MenuItem m : itemList) {
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
			switch (choice) {
				case 1:
					System.out.println("선택한 메뉴: " + itemList.get(0).getName() + ", 가격: " + itemList.get(0).getPrice() + ", 설명: " + itemList.get(0).getDetails()+ "\n");
					break;
				case 2:
					System.out.println("선택한 메뉴: " + itemList.get(1).getName() + ", 가격: " + itemList.get(1).getPrice() + ", 설명: " + itemList.get(1).getDetails()+ "\n");
					break;
				case 3:
					System.out.println("선택한 메뉴: " + itemList.get(2).getName() + ", 가격: " + itemList.get(2).getPrice() + ", 설명: " + itemList.get(2).getDetails()+ "\n");
					break;
				case 4:
					System.out.println("선택한 메뉴: " + itemList.get(3).getName() + ", 가격: " + itemList.get(3).getPrice() + ", 설명: " + itemList.get(3).getDetails()+ "\n");
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
