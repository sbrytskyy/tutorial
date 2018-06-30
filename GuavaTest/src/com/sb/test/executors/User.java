package com.sb.test.executors;

public class User {

	private final String userId;

	public User(String userId) {
		this.userId = userId;
	}

	public String getUserId() {
		return userId;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + "]";
	}
}
