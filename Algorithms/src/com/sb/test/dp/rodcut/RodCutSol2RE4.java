package com.sb.test.dp.rodcut;

public class RodCutSol2RE4 {

	public int findMaxValue(int[] prices, int length) {

		int[] dp = new int[length + 1];

		for (int l = 1; l <= length; l++) {
			int max = 0;

			for (int m = 1; m <= l; m++) {
				int value = prices[m - 1] + dp[l - m];
				if (value > max) {
					max = value;
				}
			}

			dp[l] = max;
		}

		return dp[length];
	}

	public static void main(String[] args) {

		RodCutSol2RE4 sol = new RodCutSol2RE4();

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
