package com.sb.test;

public class ThreadExceptionTest {

	class Task1 implements Runnable {

		@Override
		public void run() {
			for (int i = 0; i < 10000; i++) {
				System.out.println(Thread.currentThread().getName() + ":" + i);
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

	class Task2 implements Runnable {

		@Override
		public void run() {
			for (int i = 0; i < 10000; i++) {
				System.out.println(Thread.currentThread().getName() + ":" + i);
				
				if (i == 1000) {
					throw new RuntimeException("Shit happened");
				}
				
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	public void test() {
		Thread t1 = new Thread(new Task1(), "Task 1");
		Thread t2 = new Thread(new Task2(), "Task 2");
		t1.start();
		t2.start();
	}
	
	public static void main(String[] args) {
		ThreadExceptionTest test = new ThreadExceptionTest();
		test.test();
	}
}
