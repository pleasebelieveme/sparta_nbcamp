package assignment.kiosk.challenge1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

// 메서드 묶기 네이밍이 가장 중요!
// 해당 메서드가 많아지면 클래스를 고려
// 해당 메서드가

public class Kiosk {
	private List<Menu> menus;
	private Cart cart = new Cart(new HashMap<>());
	Kiosk() {
		this.menus = new ArrayList<>();
		menus.add(new Menu("burger"));
		menus.add(new Menu("drink"));
		menus.add(new Menu("dessert"));

		this.cart = cart;
	}

	// `main` 함수에서 관리하던 입력과 반복문 로직은 이제 `start` 함수를 만들어 관리합니다.
	public void start() {
		// Scanner 선언
		Scanner sc = new Scanner(System.in);
		boolean flag = true;
		while (flag) {
			System.out.println("\uD83E\uDD17 키오스크를 시작합니다. \uD83E\uDD17");
			System.out.println("[ MAIN MENU ]");
			for (int i = 0; i < menus.size(); i++) {
				System.out.println((i+1) + ". " + menus.get(i).getCategory());
			}
			System.out.println("0. 종료");

			if(!cart.getCartList().isEmpty()) {
				System.out.println("\n[ ORDER MENU ]");
				System.out.println("4. Orders");
				System.out.println("5. Cancle");
			}// if !cart.getCartList().isEmpty()

			// ✅카테고리 선택
			// 카테고리 사용자 입력 정수 검증
			if (!checkInteger(sc)) continue;
			// 카테고리 사용자 입력 저장
			int categoryChoice = sc.nextInt();

			// 카드에 아이템이 추가되었을 때 선택번호 추가
			int cartMenuAddIndex = 0;
			if(!cart.getCartList().isEmpty()) cartMenuAddIndex = 2;
			// 🚫카테고리 번호 범위 체크 카드사이즈더해주기
			if (categoryChoice < 0 || categoryChoice > menus.size()+cart.getCartList().size()+cartMenuAddIndex) {
				System.out.println("메뉴에 나와있는 번호를 입력해주세요.\n");
				continue;
			}
			// 카테고리 선택 처리
			if (categoryChoice >= 1 && categoryChoice <= menus.size()) {
				// ✅메뉴아이템 선택
				int idx = 1;
				System.out.println("\n[ " + menus.get(categoryChoice - 1).getCategory().toUpperCase() + " MENU ]");
				for (MenuItem m : menus.get(categoryChoice - 1).getMenuItems()) {
					System.out.println(idx++ + ". " + m.getName() + "   | W " + m.getPrice() + " | " + m.getDetails());
				}
				System.out.println("0. 뒤로가기");
				// 메뉴아이템 사용자 입력 정수 검증
				if (!checkInteger(sc))
					continue;
				// 메뉴아이템 사용자 입력 저장
				int itemChoice = sc.nextInt();
				// 메뉴 번호 범위 체크
				if (itemChoice < 0 || itemChoice > menus.get(categoryChoice - 1).getMenuItems().size()) {
					System.out.println("메뉴에 나와있는 번호를 입력해주세요.\n");
					continue;
				}

				// 메뉴 선택 처리
				// List<MenuItem> menuItems = menus.get(categoryChoice-1).getMenuItems();
				// if (itemChoice >= 1 && itemChoice <= menuItems.size()) {
				// 	System.out.println("\n선택한 메뉴: " + menuItems.get(itemChoice-1).getName() +
				// 		", 가격: " + menuItems.get(itemChoice-1).getPrice() +
				// 		", 설명: " + menuItems.get(itemChoice-1).getDetails());

				if (itemChoice >= 1 && itemChoice <= menus.get(categoryChoice - 1).getMenuItems().size()) {
					System.out.println(
						"선택한 메뉴: " + menus.get(categoryChoice - 1).getMenuItems().get(itemChoice - 1).getName() +
							", 가격: " + menus.get(categoryChoice - 1).getMenuItems().get(itemChoice - 1).getPrice() +
							", 설명: " + menus.get(categoryChoice - 1).getMenuItems().get(itemChoice - 1).getDetails()
							+ "\n");
					System.out.println("\uD83D\uDED2 위 메뉴를 장바구니에 추가하시겠습니까? \uD83D\uDED2 \n" +
						"1. 추가\n" +
						"2. 취소");

					// ✅장바구니 선택
					// 장바구니 사용자 입력 정수 검증
					if (!checkInteger(sc))
						continue;
					// 장바구니 사용자 입력 저장
					int cartChoice = sc.nextInt();
					// 장바구니 사용자 입력 번호 범위 체크
					if (cartChoice < 1 || cartChoice > 2) {
						System.out.println(menus.get(categoryChoice - 1).getMenuItems().get(itemChoice - 1).getName()
							+ "메뉴에 나와있는 번호를 입력해주세요.\n");
						continue; // 처음으로
					}
					if (cartChoice == 1) {
						System.out.println("이 장바구니에 추가되었습니다.\n");
						cart.getCartList()
							.put(menus.get(categoryChoice - 1).getMenuItems().get(itemChoice - 1), cart.getCartList()
								.getOrDefault(menus.get(categoryChoice - 1).getMenuItems().get(itemChoice - 1), 0) + 1);
					} else {
						continue;
					}
				} else if (itemChoice == 0) {
					continue; // 메뉴 맨 처음으로
				}
				// } else if (categoryChoice > menus.size() && categoryChoice <= menus.size()+cartMenuAddIndex) {
			} else if (categoryChoice==4) {
			// 🚫 기능구현 아직
				System.out.println("\n아래와 같이 주문 하시겠습니까?" +
					"\n[ Orders ]");
				if(!cart.getCartList().isEmpty()) {
					int cartIndex = 1;
					for (MenuItem menuItem : cart.getCartList().keySet()) {
						System.out.println(cartIndex + ". " + menuItem.getName() +" | W " + menuItem.getPrice() + " | "+ menuItem.getDetails() + " | 수량: " + cart.getCartList().get(menuItem));
						cartIndex++;
					}
				}// if !cart.getCartList().isEmpty()
				System.out.println("\n[ TOTAL ]");
				double totalPrice = 0;
				for (MenuItem menuItem : cart.getCartList().keySet()) {
					totalPrice += ((menuItem.getPrice()*10) * cart.getCartList().get(menuItem))/10;
				}
				System.out.println("W " + totalPrice);
				System.out.println("\n1. 주문" +
					"\n2. 메뉴판");
				if (!checkInteger(sc)) continue;
				// 카테고리 사용자 입력 저장
				int ordersChoice = sc.nextInt();

				if (ordersChoice==1) {
					System.out.println("\n주문이 완료되었습니다. 금액은 W " + totalPrice + "입니다.");
					cart.getCartList().clear();
				} else {
					continue;
				}
			} else if (categoryChoice == 5) {
				cart.getCartList().clear();
			} else if (categoryChoice == 0) {
				flag = false;
				System.out.println("프로그램을 종료합니다.");
			}
		} // while
		sc.close();
	}

	// 새로운 클래스로 ex)InputManager
	// ✅ 정수확인 메서드
	private static boolean checkInteger(Scanner sc) {
		if (!sc.hasNextInt()) {
			System.out.println("잘못된 입력입니다. 숫자를 입력해주세요.\n");
			sc.next();
			return false;
		}
		return true;
	} //checkInteger
} //main