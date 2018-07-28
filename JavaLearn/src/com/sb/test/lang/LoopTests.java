package com.sb.test.lang;

public class LoopTests {
	
	public void test() {
		for(int i = 0;;) {
			System.out.println(i++);
		}
	}

	public static void main(String[] args) {
		LoopTests t = new LoopTests();
		t.test();
	}
}
