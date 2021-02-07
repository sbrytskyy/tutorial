package com.sb.test.dp.rodcut;

import com.sb.lc.common.Utils;

public class RodCutSol2 {

	private int[][] dp;

	public int findMaxValue(int[] values, int length) {
		dp = new int[values.length + 1][length + 1];

		for (int i = 1; i <= values.length; i++) {

			for (int l = 1; l <= length; l++) {

				int cut = 0;
				if (i <= l) {
					cut = values[i - 1] + dp[i][l - i];
				}

				int skip = dp[i - 1][l];

				dp[i][l] = Math.max(cut, skip);
			}
		}

		Utils.printArray2D(dp, "DP");

		return dp[values.length][length];
	}

	public static void main(String[] args) {

		RodCutSol2 sol = new RodCutSol2();

		int[] items;
		int length;
		int maxValue;

		items = new int[] { 2, 5, 7, 3, 9 };
		length = 5;

		maxValue = sol.findMaxValue(items, length);
		System.out.println("Max Value: " + maxValue);

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

	}
}
