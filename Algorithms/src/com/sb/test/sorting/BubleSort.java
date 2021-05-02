package com.sb.test.sorting;

import java.util.Arrays;
import java.util.Random;

public class BubleSort {

	public void sort(int arr[]) {
		System.out.println("Input: " + Arrays.toString(arr));

		for (int i = arr.length - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if (arr[j] > arr[j + 1]) {
					int tmp = arr[j + 1];
					arr[j + 1] = arr[j];
					arr[j] = tmp;
				}
			}
		}
	}

	public static void main(String args[]) {

		Random r = new Random();
		int len = 5000;

		int[] arr = new int[len];
		int[] arrCopy = new int[len];

		for (int i = 0; i < len; i++) {
			arr[i] = r.nextInt();
		}
		System.arraycopy(arr, 0, arrCopy, 0, len);

		BubleSort ob = new BubleSort();
		ob.sort(arr);

		Arrays.sort(arrCopy);
		assert Arrays.equals(arr, arrCopy);

	}
}