package com.sb.test.func;

@FunctionalInterface
public interface TestBooleanFunction<T> {
	boolean verify(T message);
}
