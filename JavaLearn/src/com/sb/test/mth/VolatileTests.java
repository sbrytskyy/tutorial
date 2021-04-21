package com.sb.test.mth;

public class VolatileTests {

	static int i = 0;
	static volatile int j = 0;
	static int k = 0;
	static int l = 0;
	static int m = 0;
	static int n = 0;

	static synchronized void one() {
		i++;
		j++;
		k++;
		l++;
		m++;
		n++;
	}

	static synchronized void two() {
//		int icopy = i;
//		int jcopy = j;
		if (n > j) {
			System.out.println("j=" + j + " n=" + n);
		}
	}

	public static void main(String[] args) {
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					one();
				}
			}
		});
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					two();
//					try {
//						Thread.sleep(1);
//					} catch (InterruptedException e) {
//					}
				}
			}
		});

		t1.start();
		t2.start();
	}
}
