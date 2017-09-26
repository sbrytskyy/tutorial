package com.verizon.smarthome.test;

public class FibTest {
	
	
	public long getFib(long target) {
		long index = 0;
		long fib = 0;
		
		while (index < target) {
			fib = fib + index + index + 1;
			index += 2;
		}
		return fib;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FibTest ft = new FibTest();
		long fib = ft.getFib(4);
		System.out.println(fib);
	}

}
