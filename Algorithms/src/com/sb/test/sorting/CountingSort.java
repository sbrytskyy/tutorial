package com.sb.test.sorting;

import java.util.Arrays;
import java.util.Random;

public class CountingSort {

	public void sort(int arr[]) {
//		System.out.println("Input: " + Arrays.toString(arr));
		int k = 0;
		for (int i : arr) {
			if (i < 0) {
				throw new IllegalArgumentException();
			}
			k = Math.max(i, k);
		}

		int[] counter = new int[k + 1];
		for (int i : arr) {
			counter[i]++;
		}

		for (int i = 1; i < counter.length; i++) {
			counter[i] += counter[i - 1];
		}

//		System.out.println("Counter: " + Arrays.toString(counter));

		int[] result = new int[arr.length];

		for (int i = arr.length - 1; i >= 0; i--) {
			counter[arr[i]]--;
			int pos = counter[arr[i]];
			result[pos] = arr[i];
		}

		System.arraycopy(result, 0, arr, 0, arr.length);
//		System.out.println("Inner: " + Arrays.toString(arr));
	}

	public static void main(String args[]) {

		Random r = new Random();
		int len = 1000;
//		int len = 10;

		int[] arr = new int[len];
		int[] arrCopy = new int[len];

		for (int i = 0; i < len; i++) {
			arr[i] = r.nextInt(10);
		}

//		arr = new int[] { 9, 12, 1, 5, 7, 4, 8, 11, 3, 6 };

		System.arraycopy(arr, 0, arrCopy, 0, len);

		CountingSort ob = new CountingSort();
		ob.sort(arr);
//		System.out.println("Result: " + Arrays.toString(arr));

		Arrays.sort(arrCopy);
		assert Arrays.equals(arr, arrCopy);

	}
}