import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import chapter1.MyNewClass;

public class Main {
	public static void main(String[] args) throws IOException {
		// 주석
		System.out.println("Hello Java");


		// 클래스를 가져와서 사용할 수 있다. import생성
		new MyNewClass();

	// 	String s = "try hello world";
	// 	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	//
	// 	// 첫 번째 줄은 이미 입력 받았기 때문에 두 번째 줄의 값들을 받아옵니다.
	// 	StringTokenizer st = new StringTokenizer(s, " ");
	//
	// 	StringBuilder sb = new StringBuilder();
	//
	// 	// X보다 작은 값들만 StringBuilder에 추가
	// 	while (st.hasMoreTokens()) {
	// 		String value = st.nextToken();
	// 		char[] cArr = value.toCharArray();
	// 			for (int i = 0; i < cArr.length; i++) {
	// 				if (i % 2 == 0) { // 짝수 인덱스 → 대문자
	// 					cArr[i] = Character.toUpperCase(cArr[i]);
	// 				} else { // 홀수 인덱스 → 소문자
	// 					cArr[i] = Character.toLowerCase(cArr[i]);
	// 				}
	// 			}
	// 		sb.append(cArr).append(" ");
	// 	}
	}
}
