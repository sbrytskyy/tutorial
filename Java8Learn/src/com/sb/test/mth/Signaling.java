package com.sb.test.mth;

public class Signaling {

	private Object lockR = new Object();
	private Object lockW = new Object();

	private int i = 0;

	public void reader() {
		while (i < 100) {
			synchronized (lockW) {
				lockW.notify();
			}

			synchronized (lockR) {
				try {
					lockR.wait();
				} catch (InterruptedException e) {
				}
			}

			System.out.println(i);
		}
	}

	public void writer() {
		while (i < 100) {
			synchronized (lockW) {
				try {
					lockW.wait();
				} catch (InterruptedException e) {
				}
			}

			i++;

			synchronized (lockR) {
				lockR.notify();
			}
		}
	}

	public static void main(String[] args) {
		Signaling s = new Signaling();

		Thread tw = new Thread(new Runnable() {

			@Override
			public void run() {
				s.writer();
			}
		});
		Thread tr = new Thread(new Runnable() {

			@Override
			public void run() {
				s.reader();
			}
		});
		tw.start();
		tr.start();
	}

}
