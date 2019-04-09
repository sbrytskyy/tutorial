package com.sb.test.auto;

import org.checkerframework.checker.nullness.qual.Nullable;

import com.google.auto.value.AutoValue;

@AutoValue
abstract class Address {
	abstract String street();
	abstract String city();
	abstract String zip();
	
	static Address create(String street, String city, String zip) {
		return new AutoValue_Address(street, city, zip);
	}
}

@AutoValue
abstract class User {
	abstract Long id();
	abstract String name();
	@Nullable abstract Address address();

	static User create(Long id, String name) {
		return new AutoValue_User(id, name, null);
	}

	static User create(Long id, String name, @Nullable Address address) {
		return new AutoValue_User(id, name, address);
	}
}