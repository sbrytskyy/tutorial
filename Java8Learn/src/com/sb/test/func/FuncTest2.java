package com.sb.test.func;

import java.util.function.Function;

public class FuncTest2 {

	class DoSomethingImpl implements DoSomething {

		@Override
		public void execute() {
			System.out.println("Hello from Impl class");
		}

	}

	public void testFunct(DoSomething ds) {
		ds.execute();
	}

	public void testBuiltInFunction(Function<Long, Long> f, long l) {
		long r = f.apply(l);
		System.out.println("Function input: " + l + ", result: " + r);
	}

	void runTest() {
		testFunct(() -> System.out.println("Hello from Function"));
		testFunct(new DoSomethingImpl());

		testBuiltInFunction((l) -> l * l, 5);
	}

	public static void main(String[] args) {
		FuncTest2 t = new FuncTest2();
		t.runTest();
	}

}
