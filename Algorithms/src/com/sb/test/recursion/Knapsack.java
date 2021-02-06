package com.sb.test.recursion;

public class Knapsack {

	/**
	 * @param items  Array of pairs [weight, value]
	 * @param weight Max weight
	 * @return Max value
	 */
	private int findMax(int[][] items, int capacity) {
		return findMax(items, capacity, 0, 0);
	}

	private int findMax(int[][] items, int capacity, int index, int value) {

		if (index == items.length) {
			return value;
		}

		int itemWeight = items[index][0];
		int itemValue = items[index][1];

		int take = 0;
		if (itemWeight <= capacity) {
			take = findMax(items, capacity - itemWeight, index + 1, value + itemValue);
		}

		int skip = findMax(items, capacity, index + 1, value);

		return Math.max(take, skip);
	}

	public static void main(String[] args) {
		Knapsack sol = new Knapsack();

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
