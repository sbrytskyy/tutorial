package com.sb.test.recursion;

public class RodCutting {

	private int findMaxValue(int[] prices, int length) {

		if (length == 0) {
			return 0;
		}

		int max = 0;

		for (int cut = 1; cut <= length; cut++) {
			int value = prices[cut - 1] + findMaxValue(prices, length - cut);

//			System.out.println(String.format("length=%d, cut=%d, value = %d", length, cut, value));

			if (value > max) {
				max = value;
			}
		}

		return max;
	}

	public static void main(String[] args) {
		RodCutting sol = new RodCutting();

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
