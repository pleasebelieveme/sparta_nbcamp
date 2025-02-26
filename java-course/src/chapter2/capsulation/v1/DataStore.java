package chapter2.capsulation.v1;

// 핵시설을 관리하는 개발자
public class DataStore {
	// "B"라는 문자열이 들어오면 폭발한다.
	private String store;

	// 무분별한 세터 방지
	public void setStore(String store) {
		if(store.equals("B")) {
			System.out.println("\"B\"가 입력되면 폭발합니다.");
		} else {
			this.store = store;
		}
	}
}
