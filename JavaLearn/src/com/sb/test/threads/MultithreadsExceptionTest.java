package com.sb.test.threads;

public class MultithreadsExceptionTest {

	class Job1 implements Runnable {
		@Override
		public void run() {
			for (int i = 0; i < 200; i++) {
				System.out.println("Job 1 : " + i);
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	class Job2 implements Runnable {
		@Override
		public void run() {
			for (int i = 0; i < 200; i++) {
				System.out.println("Job 2 : " + i);
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	class Job3 implements Runnable {
		@Override
		public void run() {
			for (int i = 0; i < 100; i++) {
				System.out.println("Job 3 : " + i);
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			throw new RuntimeException("Shit happened");
		}
	}

	void runTests() {
		Thread t1 = new Thread(new Job1());
		Thread t2 = new Thread(new Job2());
		Thread t3 = new Thread(new Job3());

		t1.start();
		t2.start();
		t3.start();
	}

	public static void main(String[] args) {
		MultithreadsExceptionTest test = new MultithreadsExceptionTest();
		test.runTests();
	}
}
