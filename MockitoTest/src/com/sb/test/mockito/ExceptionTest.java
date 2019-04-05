package com.sb.test.mockito;

public class ExceptionTest {
	
	public Integer getPositiveInteger(int i) {
		if (i < 0) {
			throw new IllegalArgumentException("Only positive needed");
		}
		return Integer.valueOf(i);
	}
}
