package com.sb.test.func;

@FunctionalInterface
public interface TestFunction {
	public void doSomething(String message);
	
	default void doSomethingDefault(String message) {
		System.out.println("This is message to default method: " + message);
	}
}
