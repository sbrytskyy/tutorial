package com.sb.test.recursion;

public class Sum {

	public long sumByHeadRecursion(int num) {
		return headRecursion(num);
	}

	public long sumByTailRecursion(int num) {
		return tailRecursion(num, 0);
	}

	private long headRecursion(int num) {
		StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
		System.out.println("Head num: " + num + ".\tStack size: " + stackTrace.length + ", free memory: "
				+ Runtime.getRuntime().freeMemory());

		if (num == 1) {
			return 1;
		}
		long res = headRecursion(num - 1);

		return num + res;
	}

	private long tailRecursion(int num, int result) {
		StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
		System.out.println("Tail num: " + num + ".\tStack size: " + stackTrace.length + ", free memory: "
				+ Runtime.getRuntime().freeMemory());

		if (num == 1) {
			return 1 + result;
		}
		return tailRecursion(num - 1, num + result);
	}

	private long testByDirectSumming(int num) {
		long result = 0;
		for (int i = 1; i <= num; i++) {
			result += i;
		}
		return result;
	}

	public static void main(String[] args) {
		var sol = new Sum();

		int num = 10;
		long sumH = sol.sumByHeadRecursion(num);
		long sumT = sol.sumByTailRecursion(num);

		assert sumH == sol.testByDirectSumming(num);
		assert sumT == sumH;

		System.out.println("sum = " + sumH);
	}

}
