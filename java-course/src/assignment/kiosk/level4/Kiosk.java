package assignment.kiosk.level4;

import java.util.Scanner;

/**
 * 프로그램 순서 및 흐름 제어를 담당하는 클래스
 * 입출력을 여기서 담당
 */

public class Kiosk {
	private Scanner scanner;
	private Menu menu;

	public Kiosk() {
		scanner = new Scanner(System.in);
		menu = new Menu();
	}

	public void start() {
		System.out.println("키오스크를 시작합니다.");
		// 메뉴 아이템 가져와서 출력
	}

}
