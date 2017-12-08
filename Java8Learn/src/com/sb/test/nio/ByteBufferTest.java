package com.sb.test.nio;

import java.nio.ByteBuffer;

public class ByteBufferTest {

	private static final String STR = "\r\n\r\n";

	public static void main(String[] args) {
		ByteBufferTest bbt = new ByteBufferTest();
		bbt.test1();
	}

	private void test() {
		ByteBuffer b = ByteBuffer.allocate(32);
		b.put("hello,world".getBytes());
		b.position(6);		
		b.compact();
		System.out.println(new String(b.array()));
	}

	private void test1() {
		ByteBuffer b = ByteBuffer.allocate(32);
		
		b.put("hello\r\n\r\n world".getBytes());
		System.out.println(b);
		System.out.println(new String(b.array()));
		
//		int index = -1;
//		for (int i = 0; i < b.array().length; i++) {
//			if (b.array()[i] == ',') {
//				index = i;
//				break;
//			}
//		}
		
		String s = new String(b.array());
		int remaining = b.remaining();
		System.out.println("remaining: " + remaining);
		
		int index = s.indexOf(STR);
		System.out.println("index of '"+ STR + "': " + index);
		int used = index + STR.length();
		b.position(used);
		
		b.compact();
		System.out.println("compact: " + b);
		System.out.println(new String(b.array()));
		b.position(remaining - used);
		
		b.put("!".getBytes());
		System.out.println(b);
		System.out.println(new String(b.array()));

//		b.mark();
//		System.out.println("mark: " + b);
//		System.out.println(new String(b.array()));
//
//		b.reset();
//		System.out.println("reset: " + b);
//		System.out.println(new String(b.array()));
//
//		b.rewind();
//		System.out.println("rewind: " + b);
//		System.out.println(new String(b.array()));
//
//		b.flip();
//		System.out.println("flip: " + b);
//		System.out.println(new String(b.array()));
//
	}
}
