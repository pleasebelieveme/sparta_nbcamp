package chapter3.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Main {
	public static void main(String[] args) {

		// 배열의 한계
		// 선언과 동시에 길이 설정 필요
		int[] nums = new int[3];
		nums[0] = 10;
		nums[1] = 20;
		nums[2] = 30;
		// 배열의 정적 특징의 한
		// nums[3] = 40; // ArrayIndexOutOfBoundsException

		// 컬렉션 중 List를 구현한 ArrayList
		ArrayList<Integer> arrayList = new ArrayList<>();
		arrayList.add(10);
		arrayList.add(20);
		arrayList.add(30);
		arrayList.add(40);

		// ArrayList 활용
		ArrayList<String> names = new ArrayList<>();
		names.add("Spartan");
		names.add("G");
		names.add("K");
		names.add("1");
		// 순서 보장
		System.out.println("names = " + names); // 배열로 나오네?
		// 중복데이터 허용
		names.add("Spartan");
		System.out.println("names = " + names); // 배열로 나오네?
		// 데이터 단건 조회
		String name1 = names.get(0);
		System.out.println("name1 = " + name1);
		// 데이터 삭제
		names.remove("K");
		System.out.println("names = " + names);


		System.out.println();


		// HashSet 사용 방법
		HashSet<String> uniqueNames = new HashSet<>();
		// 데이터 추가
		uniqueNames.add("Kim");
		uniqueNames.add("Park");
		uniqueNames.add("Lee");
		uniqueNames.add("2");
		uniqueNames.add("1");
		System.out.println("uniqueNames = " + uniqueNames);
		// get() 활용불가
		// uniqueNames.get();
		// 중복불가
		uniqueNames.add("Kim"); // 에러는 발생하지 않음
		System.out.println("uniqueNames = " + uniqueNames);
		// 데이터 제거
		uniqueNames.remove("Kim");
		System.out.println("uniqueNames = " + uniqueNames);



		System.out.println();
		// HashMap 사용 방법 - <키, 값> -> 저장
		HashMap<String, Integer> memberMap = new HashMap<>();
		// 데이터 추가
		memberMap.put("Kim", 15);
		memberMap.put("Park", 6);
		memberMap.put("Lee", 36);
		memberMap.put("Hwang", 24);
		System.out.println("memberMap = " + memberMap);
		// 중복불가
		memberMap.put("Kim", 16); // 에러는 발생하지 않음
		// 키 덮어쓰기 현상 발생
		System.out.println("memberMap = " + memberMap);
		// 단건 조회
		Integer KimNum = memberMap.get("Kim");
		System.out.println("KimNum = " + KimNum);
		// 삭제
		memberMap.remove("Kim");
		System.out.println("memberMap = " + memberMap);
		// 키확인 - keyset()
		// boolean isLee = memberMap.containsKey("Lee");
		// System.out.println("isLee = " + isLee);
		Set<String> keySet = memberMap.keySet();
		System.out.println("keySet = " + keySet);
		// 값확인 - values()
		// Integer getLee = memberMap.get("Lee");
		// System.out.println("getLee = " + getLee);
		Collection<Integer> values = memberMap.values();
		System.out.println("values = " + values);

	}
}
