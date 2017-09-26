package com.sb.test;

public class BitwiseTest2 {
	
	public int numberOfOnes(int num) {
		int result = 0;
		printBinary(num);
		
		for(int i = 0; i < 32; i++) {
			if ((num & (1 << i)) != 0) result++;
		}
		
		return result;
	}

	private void printBinary(int num) {
		System.out.println(String.format("%32s", Integer.toBinaryString(num)).replace(' ', '0'));
	}
	
	public void test() {
		
	}
	
	public static void main(String[] args) {
		BitwiseTest2 t = new BitwiseTest2();
		int ones = t.numberOfOnes(123);
		System.out.println(ones);
		assert ones == 6;
		
		ones = t.numberOfOnes(1);
		System.out.println(ones);
		assert ones == 1;
		
		ones = t.numberOfOnes(-1);
		System.out.println(ones);
		assert ones == 32;
	}
}
