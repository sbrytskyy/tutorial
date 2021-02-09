package com.sb.test.dp.rodcut;

public class RodCuttingSolution {

	public int findMaxValue(int[] prices, int length) {

		// store for best prices for different lengths from 0 to length
		// if length is 0, value is 0
		int[] dp = new int[length + 1];

		for (int l = 1; l <= length; l++) {
			// we find max value for rod of length L starting from 1 to length
			int max = 0;

			for (int m = 1; m <= l; m++) {

				// cut rod of length L into two different combinations
				// value equals to price of piece of length M and best price of length L - M,
				// which is already calculated.

				int value = prices[/* price index= */ m - 1] + dp[l - m];
				if (value > max) {
					// found new better value
					max = value;
				}
			}

			// store max value for length L
			dp[l] = max;
		}

		return dp[length];
	}

	public static void main(String[] args) {

		RodCuttingSolution sol = new RodCuttingSolution();

		int[] items;
		int length;
		int maxValue;

		items = new int[] { 1, 5, 8, 9, 10, 17, 17, 20 };
		length = 8;

		maxValue = sol.findMaxValue(items, length);
		System.out.println("Max Value: " + maxValue);
		assert maxValue == 22;

		items = new int[] { 3, 5, 8, 9, 10, 17, 17, 20 };
		length = 8;

		maxValue = sol.findMaxValue(items, length);
		System.out.println("Max Value: " + maxValue);
		assert maxValue == 24;

		items = new int[] { 1, 5, 8, 9, 10, 17, 17, 20 };
		length = 4;

		maxValue = sol.findMaxValue(items, length);
		System.out.println("Max Value: " + maxValue);
		assert maxValue == 10;

//		items = new int[] { 2, 5, 7, 3, 9 };
//		length = 5;
//
//		maxValue = sol.findMaxValue(items, length);
//		System.out.println("Max Value: " + maxValue);

	}
}
