package com.sb.test.nio;

import java.nio.ByteBuffer;

public class BuffersTest {
	public static void main(String[] args) {
		BuffersTest bt = new BuffersTest();
		bt.test();
	}

	private void test() {
		ByteBuffer b1 = ByteBuffer.allocate(32);
		b1.put("hello".getBytes());

		System.out.println(b1.toString());
		
		ByteBuffer b2 = ByteBuffer.allocate(16);
		b2.put("world".getBytes());

		System.out.println(b2.toString());
		
		System.out.println("b1: " + new String(b1.array()));
		System.out.println(new String(b2.array()));

		b1.put(",".getBytes());
		System.out.println("b1: " + new String(b1.array()));
//		System.out.println(new String(b1.array()));
//		System.out.println(new String(b2.array()));
		
		b2.flip();
		System.out.println(b2.toString());
		
		b1.put(b2);
		System.out.println(b1.toString());
		System.out.println("b1: " + new String(b1.array()));
		System.out.println("b2: " + new String(b2.array()));
	}
}
