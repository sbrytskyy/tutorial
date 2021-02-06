package com.sb.test.dp.knapsack;

import com.sb.lc.common.Utils;

public class KnapsackSol1Clone {

	private int[][] dp;

	/**
	 * @param items    Array of pairs [weight, value]
	 * @param capacity Max capacity
	 * @return Max value
	 */
	private int findMax(int[][] items, int capacity) {

		dp = new int[items.length + 1][capacity + 1];

		Utils.printArray2D(dp, "DP");

		return dp[items.length][capacity];
	}

	public static void main(String[] args) {
		KnapsackSol1Clone sol = new KnapsackSol1Clone();

		int[][] items;
		int capacity;
		int maxVal;

		items = new int[][] { { 5, 10 }, { 7, 13 }, { 9, 19 }, { 2, 4 } };
		capacity = 10;
		maxVal = sol.findMax(items, capacity);
		System.out.println("Max value: " + maxVal);

		items = new int[][] { { 4, 10 }, { 2, 4 }, { 3, 7 } };
		capacity = 5;
		maxVal = sol.findMax(items, capacity);
		System.out.println("Max value: " + maxVal);
	}
}
