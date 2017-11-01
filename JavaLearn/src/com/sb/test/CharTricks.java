package com.sb.test;

public class CharTricks {

	public void test() {
		char half_limit = 1500;

		for (char i = 0; i < 2 * half_limit; ++i) {
			// do something;
			System.out.println((int)i + ":" + i);
		}
	}

	public static void main(String[] args) {
		CharTricks ct = new CharTricks();
		ct.test();
	}

}
