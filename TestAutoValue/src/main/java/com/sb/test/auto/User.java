package com.sb.test.auto;

import com.google.auto.value.AutoValue;

import com.google.common.annotations.VisibleForTesting;

@AutoValue
@VisibleForTesting
abstract class User {
	static User create(Long id, String name) {
		return new AutoValue_User(id, name);
	}
	
	abstract Long id();
	abstract String name();
}