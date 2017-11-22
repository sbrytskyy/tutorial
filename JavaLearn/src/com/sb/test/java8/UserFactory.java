package com.sb.test.java8;

import java.util.Random;
import java.util.function.Supplier;

public class UserFactory {
	
	private Random r = new Random();
	
	private static UserFactory instance = new UserFactory();
	
	private UserFactory() {
	}

	public static UserFactory getInstance() {
		return instance;
	}
	
	public Supplier<User> getNewUser() {
		long l = r.nextLong();
		return () -> new User(l, "User" + l);
	}
}
