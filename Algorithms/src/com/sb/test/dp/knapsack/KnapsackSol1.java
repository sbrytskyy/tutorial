package com.sb.test.dp.knapsack;

import com.sb.lc.common.Utils;

public class KnapsackSol1 {

	private int[][] dp;

	/**
	 * @param items  Array of pairs [weight, value]
	 * @param weight Max weight
	 * @return Max value
	 */
	private int findMax(int[][] items, int weight) {
		dp = new int[items.length + 1][weight + 1];

		for (int i = 0; i < items.length; i++) {
			int dpInd = i + 1;
			int itemWeight = items[i][0];
			int itemValue = items[i][1];
			for (int w = itemWeight; w <= weight; w++) {
				dp[dpInd][w] = Math.max(dp[dpInd - 1][w], itemValue + dp[dpInd - 1][weight - itemWeight]);
			}
		}

		Utils.printArray2D(dp, "DP");

		return dp[items.length][weight];
	}

	public static void main(String[] args) {
		KnapsackSol1 sol = new KnapsackSol1();

		int[][] items;
		int weight;
		int maxVal;

		items = new int[][] { { 5, 10 }, { 7, 13 }, { 9, 19 }, { 2, 4 } };
		weight = 10;
		maxVal = sol.findMax(items, weight);
		System.out.println("Max value: " + maxVal);

		items = new int[][] { { 4, 10 }, { 2, 4 }, { 3, 7 } };
		weight = 5;
		maxVal = sol.findMax(items, weight);
		System.out.println("Max value: " + maxVal);
	}
}
