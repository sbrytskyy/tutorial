package com.sb.test.sorting;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {

	public void sort(int arr[]) {
//		System.out.println("Input: " + Arrays.toString(arr));
		sort(arr, 0, arr.length - 1);
	}

	public void sort(int arr[], int start, int end) {
		int p = partition(arr, start, end);
		if (p == end) {
			return;
		}
		sort(arr, start, p - 1);
		sort(arr, p + 1, end);
	}

	private int partition(int[] arr, int start, int end) {
//		System.out.println(start + ":" + end);

		if (start >= end) {
			return end;
		}

		int pivot = end;

		int slow = start;
		for (int fast = start; fast < end; fast++) {

			if (arr[fast] < arr[pivot]) {
				swap(arr, slow, fast);

				slow++;
			}
		}

		swap(arr, slow, end);
//		System.out.println("slow=" + slow + ", " + Arrays.toString(arr));

		return slow;
	}

	private void swap(int[] arr, int i, int j) {
		if (i == j) {
			return;
		}
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

	public static void main(String args[]) {

		Random r = new Random();
		int len = 1000;

		int[] arr = new int[len];
		int[] arrCopy = new int[len];

		for (int i = 0; i < len; i++) {
			arr[i] = r.nextInt(10);
		}
//		arr = new int[] { 9, 12, 1, 5, 7, 4, 8, 11, 3, 6 };

		System.arraycopy(arr, 0, arrCopy, 0, len);

		QuickSort ob = new QuickSort();
		ob.sort(arr);

		Arrays.sort(arrCopy);
		assert Arrays.equals(arr, arrCopy);

	}
}