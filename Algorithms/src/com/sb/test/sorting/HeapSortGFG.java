package com.sb.test.sorting;

import java.util.Arrays;
import java.util.Random;

public class HeapSortGFG {
	public void sort(int arr[]) {
		int n = arr.length;

		// Build heap (rearrange array)
		System.out.println("Build heap (rearrange array)");
		for (int i = n / 2 - 1; i >= 0; i--) {
			heapify(arr, n, i);
//			System.out.println(i + ": " + Arrays.toString(arr));
		}
		System.out.println(Arrays.toString(arr));

		// One by one extract an element from heap
		System.out.println("One by one extract an element from heap");
		for (int i = n - 1; i > 0; i--) {
			// Move current root to end
			swap(arr, 0, i);

			// call max heapify on the reduced heap
			heapify(arr, i, 0);
//			System.out.println(i + ": " + Arrays.toString(arr));
		}
	}

	// To heapify a subtree rooted with node i which is
	// an index in arr[]. n is size of heap
	void heapify(int arr[], int n, int i) {
		int largest = i; // Initialize largest as root
		int l = 2 * i + 1; // left = 2*i + 1
		int r = 2 * i + 2; // right = 2*i + 2

		// If left child is larger than root
		if (l < n && arr[l] > arr[largest]) {
			largest = l;
		}

		// If right child is larger than largest so far
		if (r < n && arr[r] > arr[largest]) {
			largest = r;
		}

		// If largest is not root
		if (largest != i) {
			swap(arr, largest, i);

			// Recursively heapify the affected sub-tree
			heapify(arr, n, largest);
		}
	}

	private void swap(int[] arr, int i, int j) {
		if (i == j) {
			return;
		}
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

	// Driver code
	public static void main(String args[]) {

		Random r = new Random();
		int len = 1000000;

		int[] arr = new int[len];
		int[] arrCopy = new int[len];

		for (int i = 0; i < len; i++) {
			arr[i] = r.nextInt(len);
		}
		System.arraycopy(arr, 0, arrCopy, 0, len);

		HeapSortGFG ob = new HeapSortGFG();
		ob.sort(arr);

		Arrays.sort(arrCopy);
		assert Arrays.equals(arr, arrCopy);

	}
}