package com.sb.test.recursion;

public class Factorial {

	public long factorialByHeadRecursion(int num) {
		return headRecursion(num);
	}

	public long factorialByTailRecursion(int num) {
		return tailRecursion(num, 1);
	}

	private long headRecursion(int num) {
		System.out.println("Head start. num: " + num);
//		StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
//		System.out.println("Head num: " + num + ".\tStack size: " + stackTrace.length + ", free memory: "
//				+ Runtime.getRuntime().freeMemory());

		if (num == 1) {
			System.out.println("Head end. num: " + num + ", return: " + 1);
			return 1;
		}
		long res = num * headRecursion(num - 1);

		System.out.println("Head end. num: " + num + ", return: " + res);
		return res;
	}

	private long tailRecursion(int num, int result) {
		System.out.println("Tail start. num: " + num + ", result: " + result);
//		StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
//		System.out.println("Tail num: " + num + ".\tStack size: " + stackTrace.length + ", free memory: "
//				+ Runtime.getRuntime().freeMemory());

		if (num == 1) {
			System.out.println("Tail end. num: " + num + ", return: " + result);
			return result;
		}
		long res = tailRecursion(num - 1, num * result);

		System.out.println("Tail end. num: " + num + ", return: " + res);
		return res;
	}

	private long testByDirectMultiplying(int num) {
		long result = 1;
		for (int i = 1; i <= num; i++) {
			result *= i;
		}
		return result;
	}

	public static void main(String[] args) {
		var sol = new Factorial();

		int num = 10;
		long fH = sol.factorialByHeadRecursion(num);
		long fT = sol.factorialByTailRecursion(num);

		assert fH == sol.testByDirectMultiplying(num);
		assert fT == fH;

		System.out.println("factorial = " + fH);
	}

}
