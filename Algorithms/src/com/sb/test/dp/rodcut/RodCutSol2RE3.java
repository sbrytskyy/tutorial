package com.sb.test.dp.rodcut;

public class RodCutSol2RE3 {

	public int findMaxValue(int[] prices, int length) {

		int dp[] = new int[length + 1];

		for (int cut = 1; cut <= length; cut++) {
			for (int subcut = 1; subcut <= cut; subcut++) {
				dp[cut] = Math.max(dp[cut], prices[subcut - 1] + dp[cut - subcut]);
			}
		}

		return dp[length];
	}

	public static void main(String[] args) {

		RodCutSol2RE3 sol = new RodCutSol2RE3();

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
