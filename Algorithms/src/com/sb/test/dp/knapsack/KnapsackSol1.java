package com.sb.test.dp.knapsack;

import java.util.Arrays;

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
			dp[i + 1][weight] = items[i][0];
		}

		int maxValue = 0;
		int w = weight;

		for (int i = 0; i < items.length; i++) {
			int dpInd = i + 1;

			int itemWeight = items[i][0];
			int itemValue = items[i][1];

			if (itemWeight > w) {
				System.out.println("Item " + Arrays.toString(items[i]) + " not included as it's too heavy");
				continue;
			}

			dp[dpInd][w] = dp[dpInd - 1][w];
			dp[dpInd][w - itemWeight] = dp[dpInd - 1][w] + itemValue;

			int max = 0;
			if (dp[dpInd][w] > dp[dpInd][w - itemWeight]) {
				max = dp[dpInd][w];
				System.out.println("Item " + Arrays.toString(items[i]) + " not included");
			} else {
				max = dp[dpInd][w - itemWeight];
				System.out.println("Item " + Arrays.toString(items[i]) + " included");
				w -= itemWeight;
			}
			maxValue += max;
		}

		Utils.printArray2D(dp, "DP");

		return maxValue;
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
