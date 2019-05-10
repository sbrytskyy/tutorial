package com.sb.test.func;

public class TestFunctionImpl implements TestFunction {

	@Override
	public void doSomething(String message) {
		System.out.println("Hello from TestFunction: " + message);
	}

}
