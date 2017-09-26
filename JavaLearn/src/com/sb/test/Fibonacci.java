package com.sb.test;
import java.math.BigInteger;

public class Fibonacci {

	public static void main(String[] args) {
		Fibonacci f = new Fibonacci();

		for (int i = 0; i < 1000000; i++) {
			BigInteger fibonacci = f.getFibonacci(i);
			System.out.println("" + i + ": " + fibonacci);
		}
	}

	private BigInteger getFibonacci(int target) {

		BigInteger f1 = BigInteger.valueOf(0);
		BigInteger f2 = BigInteger.valueOf(1);
		BigInteger fib = f1.add(f2);

		for (int i = 2; i < target; i++) {
			f1 = f2;
			f2 = fib;
			fib = f1.add(f2);
		}

		return fib;
	}
}
