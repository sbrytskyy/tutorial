package com.sb.test.auto;

import static com.google.common.truth.Truth.assertThat;

import org.junit.Test;

public class UserTest {

	@Test
	public void testCreate() {
		assertThat(User.create(1L, "test1")).isNotNull();
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
