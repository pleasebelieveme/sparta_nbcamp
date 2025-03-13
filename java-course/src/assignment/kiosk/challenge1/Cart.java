package assignment.kiosk.challenge1;

import java.util.Map;

// 카드아이템으로 수정
public class Cart {
	// name, price를 합쳐서 MenuItem 객체로
	// private String name; // 메뉴명
	// private int quantity; // 수량
	// private double price; // 가격

	// Integer 수량
	private Map<MenuItem, Integer> cartList;

	public Cart(Map<MenuItem, Integer> cartList) {
		this.cartList = cartList;
	}

	public Map<MenuItem, Integer> getCartList() {
		return cartList;
	}

	public void setCartList(Map<MenuItem, Integer> cartList) {
		this.cartList = cartList;
	}
}


