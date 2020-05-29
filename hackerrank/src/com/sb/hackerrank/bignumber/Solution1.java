package com.sb.hackerrank.bignumber;

import java.math.BigDecimal;
import java.util.Arrays;

public class Solution1 {

	public static void main(String[] args) {
		// Input
		String[] s = new String[] { "9", "-100", "50", "0", "56.6", "90", "0.12", ".12", "02.34", "000.000", "", "" };
//		String[] s = new String[] { "9", "1", "5", "0", "6", "9", "12", "11", "2", "0", "", "" };
		int n = s.length - 2;

		for (int i = 0; i < n; i++) {
			BigDecimal smallest = new BigDecimal(s[i]);
			int smallestIndex = i;

			for (int j = i + 1; j < n; j++) {
				BigDecimal bd = new BigDecimal(s[j]);
				if (bd.compareTo(smallest) < 0) {
					smallest = bd;
					smallestIndex = j;
				}
			}
			System.out.println(String.format("i: %d, smallestIndex: %d, smallest: %s", i, smallestIndex, smallest));

			if (smallestIndex != i) {
				s[n + 1] = s[smallestIndex];
				for (int j = smallestIndex; j > i; j--) {
					s[j] = s[j - 1];
				}
				s[i] = s[n + 1];
			}

			System.out.println(Arrays.toString(s));
		}

		// Output
		for (int i = 0; i < n; i++) {
			System.out.println(s[i]);
		}
	}
}
