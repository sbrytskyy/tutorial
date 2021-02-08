package com.sb.test.dp.rodcut;

public class RodCuttingDP {

	private int findMaxValue(int[] prices, int length) {

		int[] dp = new int[length + 1];

		for (int l = 1; l <= length; l++) {

			for (int cut = 1; cut <= l; cut++) {
				int value = prices[cut - 1] + dp[l - cut];

				System.out.println(String.format("l-cut=%d, value = %d", (l - cut), value));

				if (value > dp[l]) {
					dp[l] = value;
				}
			}
		}

		return dp[length];
	}

	public static void main(String[] args) {
		RodCuttingDP sol = new RodCuttingDP();

		int[] prices;
		int length;
		int maxValue;

		prices = new int[] { 1, 5, 8, 9, 10, 17, 17, 20 };
		length = 8;

		maxValue = sol.findMaxValue(prices, length);
		System.out.println("Max Value: " + maxValue);
		assert maxValue == 22;

		prices = new int[] { 3, 5, 8, 9, 10, 17, 17, 20 };
		length = 8;

		maxValue = sol.findMaxValue(prices, length);
		System.out.println("Max Value: " + maxValue);
		assert maxValue == 24;

		prices = new int[] { 1, 5, 8, 9, 10, 17, 17, 20 };
		length = 4;

		maxValue = sol.findMaxValue(prices, length);
		System.out.println("Max Value: " + maxValue);
		assert maxValue == 10;

	}

}
