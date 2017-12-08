package com.sb.test;
import java.util.function.Function;

public class DataStructure {

	// Create an array
	private final static int SIZE = 15;
	private int[] arrayOfInts = new int[SIZE];

	public DataStructure() {
		// fill the array with ascending integer values
		for (int i = 0; i < SIZE; i++) {
			arrayOfInts[i] = i;
		}
	}

	public void printEven() {

		// Print out values of even indices of the array
		DataStructureIterator iterator = new EvenIterator();
		while (iterator.hasNext()) {
			System.out.print(iterator.next() + " ");
		}
		System.out.println();
	}

	public void testPrint1() {
		// Print out values of even indices of the array
		print(new DataStructureIterator() {
			// Start stepping through the array from the beginning
			private int nextIndex = 0;

			@Override
			public boolean hasNext() {
				return (nextIndex <= SIZE - 1);
			}

			@Override
			public Integer next() {

				// Record a value of an even index of the array
				Integer retValue = Integer.valueOf(arrayOfInts[nextIndex]);

				// Get the next even element
				nextIndex += 2;
				return retValue;
			}

		});
	}

	private void print(DataStructureIterator iterator) {
		while (iterator.hasNext()) {
			System.out.print(iterator.next() + " ");
		}
		System.out.println();
	}

	public void testPrint2() {
		print(i -> i % 2 == 0);
	}

	private void print(Function<Integer, Boolean> iterator) {
		for (int i = 0; i < arrayOfInts.length; i++) {
			if (iterator.apply(arrayOfInts[i])) {
				System.out.print(arrayOfInts[i] + " ");
			}
		}
		System.out.println();
	}

	interface DataStructureIterator extends java.util.Iterator<Integer> {
	}

	// Inner class implements the DataStructureIterator interface,
	// which extends the Iterator<Integer> interface

	private class EvenIterator implements DataStructureIterator {

		// Start stepping through the array from the beginning
		private int nextIndex = 0;

		public boolean hasNext() {

			// Check if the current element is the last in the array
			return (nextIndex <= SIZE - 1);
		}

		public Integer next() {

			// Record a value of an even index of the array
			Integer retValue = Integer.valueOf(arrayOfInts[nextIndex]);

			// Get the next even element
			nextIndex += 2;
			return retValue;
		}
	}

	public static void main(String s[]) {

		// Fill the array with integer values and print out only
		// values of even indices
		DataStructure ds = new DataStructure();
		ds.printEven();

		ds.testPrint1();
		ds.testPrint2();
	}
}