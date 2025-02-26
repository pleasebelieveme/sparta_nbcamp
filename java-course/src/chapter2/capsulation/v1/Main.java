package chapter2.capsulation.v1;

public class Main {
	public static void main(String[] args) {
		DataStore dataStore = new DataStore();
		// dataStore.store = "A";
		dataStore.setStore("B");
	}
}
