package com.sb.test.java8;

import java.util.Arrays;
import java.util.Random;
import java.util.function.IntBinaryOperator;

public class ArraysTest {

	public static void main(String[] args) {
		ArraysTest t = new ArraysTest();

		System.out.println(1 << 13);

		for (int i = 0; i < 5; i++)
			t.test1();
	}

	private void test1() {
		Random r = new Random();
		int[] ar1 = new int[1000000];

		for (int i = 0; i < ar1.length; i++) {
			ar1[i] = r.nextInt();
		}

		int[] ar2 = new int[ar1.length];
		System.arraycopy(ar1, 0, ar2, 0, ar1.length);

		Arrays.stream(ar1).limit(10).forEach(i -> System.out.print(i + " "));
		System.out.println();

		long start = System.currentTimeMillis();
		Arrays.sort(ar1);
		long end = System.currentTimeMillis();
		System.out.println("Single: " + (end - start));

		start = System.currentTimeMillis();
		Arrays.parallelSort(ar1);
		end = System.currentTimeMillis();
		System.out.println("Parallel: " + (end - start));
	}

}
