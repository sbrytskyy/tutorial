package com.sb.test.auto;

import static com.google.common.truth.Truth.assertThat;

import org.junit.Test;

public class UserTest {

	@Test
	public void testCreate() {
		User user1 = User.create(1L, "test1");
		assertThat(user1).isNotNull();
		assertThat(user1.toString()).isEqualTo("User{id=1, name=test1, address=null}");

		Address address = Address.create("SW Expy", "San Jose", "95126");
		User user2 = User.create(1L, "test1", address);
		assertThat(user2).isNotNull();
	}

	@Test
	public void testId() {
		assertThat(User.create(1L, "test1").id()).isEqualTo(1L);
	}

	@Test
	public void testName() {
		assertThat(User.create(1L, "test1").name()).isEqualTo("test1");
	}
}
