package com.sb.test.auto;

public class Main implements Runnable {
	
	@Override
	public void run() {
		User user1 = User.create(1L, "test1");
		System.out.println("User: " + user1);
	}

	public static void main(String[] args) {
		Main m = new Main();
		m.run();
	}
}
