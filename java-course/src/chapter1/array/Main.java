package chapter1.array;

public class Main {
	public static void main(String[] args) {
		// 모험가 명단을 관리하는 법
		String name1 = "kim";
		String name2 = "park";

		String[] adventurerList = {"kim", "park"};

		// 배열 선언 및 길이 할당 -> 공간 점유(정적 배열), 길이를 바꿀 수 없다.
		int[] arr = new int[5];

		// 배열 선언 및 요소 할당
		int[] arr2 = {10, 20, 30, 40, 50};
		
		int arr2Length = arr2.length;
		System.out.println("arr2Length = " + arr2Length);

		// 문자열 배열 선언
		String[] strArr = new String[5];

		// 논리형 배열 선언
		Boolean[] boolArr = new Boolean[3];

		// 배열에 요소에 접근: 인덱스 활용 방법
		int[] intArr = {10, 20, 30, 40, 50};
		System.out.println("배열에 1번째 요소 접근: " + intArr[0]);

		// 요소 변경
		intArr[0] = 100;
		System.out.println("배열에 1번째 요소 변경: " + intArr[0]);

		for (int i = 0; i <intArr.length ; i++) {
			System.out.println("인덱스: " + i + " 값: " + intArr[i]);
		}

		// 향상된 for문
		for (int a : intArr) System.out.println("값: " + a);

		// 2차원 배열, 바둑판 true 검은돌, false 흰돌 [가로][세로]
		// boolean[][] board = new boolean[2][2];
		boolean[][] board = {
			{true, false},
			{false, true}
		};
		System.out.println(board[0][0]);
	}
}
