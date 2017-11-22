package com.sb.test.java8;

public class UsersTest {

	public static void main(String[] args) {
		UsersTest t = new UsersTest();
		t.test1();
	}

	private void test1() {
		UserProcessor up = new UserProcessor();
		up.addToRoster(User::new);
		up.addToRoster(UserFactory.getInstance().getNewUser());
		up.authorizeAll();
	}

}
