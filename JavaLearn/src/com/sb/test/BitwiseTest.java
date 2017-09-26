package com.sb.test;
import java.util.Random;

public class BitwiseTest {

	public void testIntDiv() {
		Random r = new Random();

		for (int j = 0; j < 1000000; j++) {
			int i = Math.abs(r.nextInt());

			int i1 = i >> 1;
			int i2 = i / 2;
			
			assert i1 == i2 : "i: " + i;
		}
	}

	public void testRndUnsShift() {
		Random r = new Random();

		for (int j = 0; j < 1000000; j++) {
			int i = Math.abs(r.nextInt());

			int i1 = i >>> 1;
			int i2 = i1 << 1;
			
			assert i == i2 : "i: " + i;
		}
	}

	public void testShift() {
		Random r = new Random();
		int i1 = r.nextInt();
		i1 = Integer.MIN_VALUE;
		System.out.println("i1: " + i1);
		System.out.println("i1: " + String.format("%32s", Integer.toBinaryString(i1)).replace(' ', '0'));

		System.out.println("/2: " + i1 / 2);

		int i = i1 >> 1;
		System.out.println(">>: " + i);
		System.out.println("i : " + String.format("%32s", Integer.toBinaryString(i)).replace(' ', '0'));

		i = i << 1;
		System.out.println("<<: " + i);
		System.out.println("i : " + String.format("%32s", Integer.toBinaryString(i)).replace(' ', '0'));
	}

	public void testUnsShift() {
		Random r = new Random();
		int i1 = r.nextInt();
		i1 = Integer.MAX_VALUE;
		System.out.println("i1: " + i1);
		System.out.println("i1: " + String.format("%32s", Integer.toBinaryString(i1)).replace(' ', '0'));

		System.out.println("/2: " + i1 / 2);

		int i = i1 >>> 1;
		System.out.println(">>: " + i);
		System.out.println("i : " + String.format("%32s", Integer.toBinaryString(i)).replace(' ', '0'));

		i = i << 1;
		System.out.println("<<: " + i);
		System.out.println("i : " + String.format("%32s", Integer.toBinaryString(i)).replace(' ', '0'));
	}

	public void testXOR() {
		Random r = new Random();
		int i1 = r.nextInt();
		System.out.println("i1: " + Integer.toBinaryString(i1));
		int i2 = r.nextInt();
		System.out.println("i2: " + Integer.toBinaryString(i2));

		int i = i1;
		i ^= i2;
		System.out.println("i : " + Integer.toBinaryString(i));

		i ^= i2;
		System.out.println("i : " + Integer.toBinaryString(i));

		assert i == i1;
	}

	public void testShifts() {
		int pos = 1;
//		shifts(pos);
//		
		pos = Integer.MAX_VALUE;
		shifts(pos);
//
		int neg = -1;
//		shifts(neg);
//		
		neg = Integer.MIN_VALUE;
		shifts(neg);
		
//		System.out.println(pos & neg);
	}

	private void shifts(int i1) {
		System.out.println("\n\ni1 : " + i1);
		System.out.println("i1 : " + String.format("%32s", Integer.toBinaryString(i1)).replace(' ', '0'));

//		System.out.println("/2: " + i1 / 2);

		int i = i1 >> 1;
		System.out.println(">> : " + i);
		System.out.println("i  : " + String.format("%32s", Integer.toBinaryString(i)).replace(' ', '0'));

		i = i1 >>> 1;
		System.out.println(">>>: " + i);
		System.out.println("i  : " + String.format("%32s", Integer.toBinaryString(i)).replace(' ', '0'));

		i = i1 << 1;
		System.out.println("<< : " + i);
		System.out.println("i  : " + String.format("%32s", Integer.toBinaryString(i)).replace(' ', '0'));
	}
	
	public static void main(String[] args) {
		BitwiseTest t = new BitwiseTest();
		t.testShifts();
	}
}
