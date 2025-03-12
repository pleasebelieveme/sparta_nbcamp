package assignment.kiosk.challenge1;

public class Main {
	public static void main(String[] args) {
		// // Menu 객체 생성하면서 카테고리 이름 설정
		//
		// Menu burgers = new Menu("burger");
		// Menu drinks = new Menu("drink");
		// Menu desserts = new Menu("dessert");

		// Menu 클래스 내 있는 List<MenuItem> 에 MenuItem 객체 생성하면서 삽입
		Kiosk kiosk = new Kiosk();
		kiosk.start();
	}
}
