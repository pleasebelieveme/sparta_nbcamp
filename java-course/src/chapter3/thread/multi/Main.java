package chapter3.thread.multi;

public class Main {
	public static void main(String[] args) {
		System.out.println("::: main 쓰레드 시작");
		MyThread thread0 = new MyThread();
		MyThread thread1 = new MyThread();

		// 1. thread0 시작
		System.out.println("thread0 시작");
		thread0.start();

		// 2. thread1 시작
		System.out.println("thread1 시작");
		thread1.start();

		// 메인스레드는 이미 작업종료
		System.out.println("::: main 쓰레드 종료");
	}
}
