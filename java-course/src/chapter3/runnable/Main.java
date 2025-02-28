package chapter3.runnable;

public class Main {
	public static void main(String[] args) {
		MyRunnable myTask = new MyRunnable();

		// 기능을 확장해서 사용
		myTask.printMessage();

		Thread thread0 = new Thread(myTask);
		Thread thread1 = new Thread(myTask);

		thread0.start();
		thread1.start();
	}
}
