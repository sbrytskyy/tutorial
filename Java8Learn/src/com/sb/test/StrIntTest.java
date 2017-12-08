package com.sb.test;

public class StrIntTest {

	public static void main(String[] args) {
		StrIntTest t = new StrIntTest();
		t.test2();
	}

	private void test() {
		String s = "123453453534563636463";
		byte[] b = new byte[s.length()];

		long result = 0;
		for (int i = 0; i < s.length(); i++) {
			b[i] = (byte) (s.charAt(i) - 48);

			result += b[i] * Math.pow(10, b.length - 1 - i);
		}
		System.out.println(result);
	}

	public void test2() {
		int[][] array = { { 17, 3, 2, 13 }, { 5, 12, 11, 8 }, { 9, 6, 10, 12 }, { 4, 15, 14, 5 } };
		method(array);
	}

	private void method(int[][] array) {
		int[] var = new int[array[0].length];
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				var[j] += array[i][j];
			}
		}
		
		System.out.println();
	}
}
