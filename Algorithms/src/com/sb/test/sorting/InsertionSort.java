package com.sb.test.sorting;

import java.util.Arrays;

public class InsertionSort {

	public void sort(int arr[]) {
		System.out.println("Input: " + Arrays.toString(arr));
		int n = arr.length;
		for (int i = 1; i < n; ++i) {
			int key = arr[i];
			System.out.println("key=" + key);
			int j = i - 1;

			/*
			 * Move elements of arr[0..i-1], that are greater than key, to one position
			 * ahead of their current position
			 */
			while (j >= 0 && arr[j] > key) {
				arr[j + 1] = arr[j];
				j = j - 1;
			}
			arr[j + 1] = key;
			System.out.println(i + ": " + Arrays.toString(arr));
		}
	}

	public static void main(String args[]) {
		int arr[] = { 12, 11, 13, 5, 6 };

		InsertionSort ob = new InsertionSort();
		ob.sort(arr);

		System.out.println("Result: " + Arrays.toString(arr));
	}
}