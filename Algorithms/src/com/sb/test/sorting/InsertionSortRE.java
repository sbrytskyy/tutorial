package com.sb.test.sorting;

import java.util.Arrays;
import java.util.Random;

public class InsertionSortRE {

	public void sort(int arr[]) {
		System.out.println("Input: " + Arrays.toString(arr));

		for (int i = 1; i < arr.length; i++) {
			int tmp = arr[i];
			int min = i;

			for (int j = i - 1; j >= 0; j--) {
				if (arr[j] <= tmp) {
					break;
				}
				arr[j + 1] = arr[j];
				min = j;
			}
			arr[min] = tmp;
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

		InsertionSortRE ob = new InsertionSortRE();
		ob.sort(arr);

		Arrays.sort(arrCopy);
		assert Arrays.equals(arr, arrCopy);

	}
}