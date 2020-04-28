package com.sb.lmb;

public class Main {

	public static void main(String[] args) {
		Main m = new Main();
		m.run();

	}

	private void run() {
		testUser();

	}

	private void testUser() {
		User user = new User();
		user.setFirstName("John");
		System.out.println(user);
	}

}
