package com.sb.test.dp.knapsack;

import java.util.Arrays;

import com.sb.lc.common.Utils;

public class KnapsackSol1Clone {

	private int[][] dp;

	/**
	 * @param items    Array of pairs [weight, value]
	 * @param capacity Max capacity
	 * @return Max value
	 */
	public int findMax(int[][] items, int capacity) {

		dp = new int[items.length + 1][capacity + 1];

		for (int i = 1; i <= items.length; i++) {
			int itemWeight = items[i - 1][0];
			int itemValue = items[i - 1][1];

			for (int w = 1; w <= capacity; w++) {

				int take = 0;
				if (itemWeight <= w) {
					take = itemValue + dp[i - 1][w - itemWeight];
				}

				int skip = dp[i - 1][w];

				dp[i][w] = Math.max(take, skip);
			}
		}

		Utils.printArray2D(dp, "DP");

		return dp[items.length][capacity];
	}

	public void printUsedItems(int[][] items, int capacity) {
		int w = capacity;
		for (int i = items.length; i >= 0; i--) {
			if (dp[i][w] != 0 && dp[i][w] > dp[i - 1][w]) {
				System.out.println("Used item: " + Arrays.toString(items[i - 1]));
				w -= items[i - 1][0];
			}
		}
	}

	public static void main(String[] args) {
		KnapsackSol1Clone sol = new KnapsackSol1Clone();

		int[][] items;
		int capacity;
		int maxVal;

		items = new int[][] { { 5, 10 }, { 7, 13 }, { 9, 19 }, { 2, 4 } };
		capacity = 10;
		maxVal = sol.findMax(items, capacity);
		System.out.println("Capacity: " + capacity);
		System.out.println("Max value: " + maxVal);
		sol.printUsedItems(items, capacity);

		items = new int[][] { { 4, 10 }, { 2, 4 }, { 3, 7 } };
		capacity = 5;
		maxVal = sol.findMax(items, capacity);
		System.out.println("Capacity: " + capacity);
		System.out.println("Max value: " + maxVal);
		sol.printUsedItems(items, capacity);
	}
}
