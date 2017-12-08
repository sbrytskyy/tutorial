package com.sb.test.deadlock;

public class DeadLock1 {
	
	
	private Object lockA = new Object();
	private Object lockB = new Object();

	
	public void runA() {
		synchronized (lockA) {
			System.out.println("Aquired lockA");
			synchronized (lockB) {
				System.out.println("Aquired lockB");
				System.out.println("runA");
			}
		}
		
	}
	
	public void runB() {
		synchronized (lockB) {
			System.out.println("Aquired lockB");
			synchronized (lockA) {
				System.out.println("Aquired lockA");
				System.out.println("runB");
			}
		}
		
	}

	public static void main(String[] args) {
		DeadLock1 dl = new DeadLock1();
		
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				dl.runA();
			}
			
		});

		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				dl.runB();
			}
			
		});
		
		t1.start();
		t2.start();
	}
}
