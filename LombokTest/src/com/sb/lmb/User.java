package com.sb.lmb;

import java.io.Serializable;

import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Data
public class User implements Serializable {

	private static final long serialVersionUID = 1496276876827456907L;

	@NonNull
	@Getter
	@Setter
	private Long id; // will be set when persisting

	@Getter
	@Setter
	private String firstName;
	@Getter
	@Setter
	private String lastName;
	@Getter
	@Setter
	private int age;

	public User() {
	}

	public User(String firstName, String lastName, int age) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}

	// getters and setters: ~30 extra lines of code
}