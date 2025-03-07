package assignment.kiosk.level2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * 	// add 함수를 통해 new MenuItem(이름, 가격, 설명) List에 삽입
 *
 *
 *
 *
 * 		// 숫자를 입력 받기
 * 		// 입력된 숫자에 따른 처리
 * 		// 프로그램을 종료
 * 		// 선택한 메뉴 : 이름, 가격, 설명 등을 출력
 */
public class Main {
	public static void main(String[] args) {
		// List 선언 및 초기화
		List<MenuItem> list = new ArrayList<>();

		// Scanner 선언
		Scanner sc = new Scanner(System.in);
		boolean flag = true;

		while (flag) {
			System.out.println("\uD83E\uDD17 키오스크를 시작합니다. \uD83E\uDD17");
			System.out.println("1. ShackBurger   | W 6.9 | 토마토, 양상추, 쉑소스가 토핑된 치즈버거\n"
				+ "2. SmokeShack    | W 8.9 | 베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거\n"
				+ "3. Cheeseburger  | W 6.9 | 포테이토 번과 비프패티, 치즈가 토핑된 치즈버거\n"
				+ "4. Hamburger     | W 5.4 | 비프패티를 기반으로 야채가 들어간 기본버거\n"
				+ "0. 종료");

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
					System.out.println("ShackBurger를 선택하셨습니다.\n");
					break;
				case 2:
					System.out.println("SmokeShack를 선택하셨습니다.\n");
					break;
				case 3:
					System.out.println("Cheeseburger를 선택하셨습니다.\n");
					break;
				case 4:
					System.out.println("Hamburger를 선택하셨습니다.\n");
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
