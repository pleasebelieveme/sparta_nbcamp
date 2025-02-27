package assignment.calculator.ui;
public class Display {
	public void ui() {
		System.out.println("+---------------------------+");
		System.out.println("| ////// Calculator /////// |");
		System.out.println("+---------------------------+");
		System.out.println("| [              1,264.45 ] |");
		System.out.println("+---------------------------+");
		System.out.println("| [ 7 ] [ 8 ] [ 9 ] [  *  ] |");
		System.out.println("| [ 4 ] [ 5 ] [ 6 ] [  -  ] |");
		System.out.println("| [ 1 ] [ 2 ] [ 3 ] [  +  ] |");
		System.out.println("| [ 0 ] [ . ] [+/-] [  =  ] |");
		System.out.println("+---------------------------+");
	}
	public void menu() {
		System.out.println("메뉴를 입력하세요: ");
		System.out.println("1. 두개의 숫자로 사칙연산하기");
		System.out.println("0. 종료하기");
	}
}
