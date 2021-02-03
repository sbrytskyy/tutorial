package com.sb.test.tailrecursion;

public class Factorial {
	public static TailCall<Long> factorialTailRec(final Long factorial, final int number) {
		StackTraceHelper.printStackTrace();
		if (number == 1) {
			return TailCalls.done(factorial);
		} else {
			return () -> factorialTailRec(factorial * number, number - 1);
		}
	}
}