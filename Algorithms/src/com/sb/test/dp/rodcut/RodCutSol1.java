package com.sb.test.dp.rodcut;

import com.sb.lc.common.Utils;

public class RodCutSol1 {

	private int[][] dp;

	public int findMaxValue(int[][] items, int length) {
		dp = new int[items.length + 1][length + 1];

		for (int i = 1; i <= items.length; i++) {

			int itemLength = items[i - 1][0];
			int itemValue = items[i - 1][1];

			for (int l = 1; l <= length; l++) {

				int cut = 0;
				if (itemLength <= l) {
					cut = itemValue + dp[i][l - itemLength];
				}

				int skip = dp[i - 1][l];

				dp[i][l] = Math.max(cut, skip);
			}
		}

		Utils.printArray2D(dp, "DP");

		return dp[items.length][length];
	}

	public static void main(String[] args) {

		RodCutSol1 sol = new RodCutSol1();

		int[][] items;
		int length;
		int maxValue;

		items = new int[][] { { 1, 2 }, { 2, 5 }, { 3, 7 }, { 4, 3 }, { 5, 9 } };
		length = 5;

		maxValue = sol.findMaxValue(items, length);
		System.out.println("Max Value: " + maxValue);

		items = new int[][] { { 1, 1 }, { 2, 5 }, { 3, 8 }, { 4, 9 }, { 5, 10 }, { 6, 17 }, { 7, 17 }, { 8, 20 } };
		length = 8;

		maxValue = sol.findMaxValue(items, length);
		System.out.println("Max Value: " + maxValue);
		assert maxValue == 22;

		items = new int[][] { { 1, 3 }, { 2, 5 }, { 3, 8 }, { 4, 9 }, { 5, 10 }, { 6, 17 }, { 7, 17 }, { 8, 20 } };
		length = 8;

		maxValue = sol.findMaxValue(items, length);
		System.out.println("Max Value: " + maxValue);
		assert maxValue == 24;

	}
}
