package com.sb.test.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class UserProcessor {
	
	List<User> users = new ArrayList<>();
	
	public void addToRoster(Supplier<User> supplier) {
		users.add(supplier.get());
	}
	
	void authorize(User user) {
		System.out.println("Authorize user " + user);
	}
	
	public void authorizeAll() {
		users.forEach(u -> authorize(u));
	}

}
