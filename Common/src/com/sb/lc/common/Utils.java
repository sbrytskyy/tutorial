package com.sb.lc.common;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class Utils {

	public static void printIntegerAsBinary(int i) {
		System.out.println(
				String.format("%16s", i) + " : " + String.format("%32s", Integer.toBinaryString(i)).replace(' ', '0'));
	}

	public static void printLongAsBinary(long l) {
		System.out.println(
				String.format("%32s", l) + " : " + String.format("%64s", Long.toBinaryString(l)).replace(' ', '0'));
	}

	public static TreeSet<Integer> getPrimeNumbers(int maxSimple) {
		TreeSet<Integer> primeNumbers = new TreeSet<>();

		int[] eratosthenes = new int[maxSimple];
		for (int i = 1; i <= maxSimple; i++) {
			eratosthenes[i - 1] = i;
		}

		primeNumbers.add(1);
		int index = 1;
		while (index < maxSimple) {
			int simple = eratosthenes[index];
			if (simple != 0) {
				primeNumbers.add(simple);
				int i = index + 1;
				while (i <= maxSimple - simple) {
					i += simple;
					eratosthenes[i - 1] = 0;
				}
			}

			index++;
		}

		return primeNumbers;
	}

	public static List<String> readFile(String filename) {
		try {
			String content = new String(Files.readAllBytes(Paths.get(filename)));
			content = content.replaceAll("\"", "");
			content = content.replaceAll("\n", "");
			int start = content.indexOf('[');
			int end = content.indexOf(']');
			content = content.substring(start > -1 ? start + 1 : 0, end > -1 ? end : content.length());
			String[] ar = content.split(",");
			List<String> l = new ArrayList<>();
			for (String s : ar) {
				l.add(s);
			}
			System.out.println("Input List size: " + l.size());
			return l;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void printArray(int[][] r, String title) {
		System.out.print(title + ": [");
		for (int i = 0; i < r.length; i++) {
			int[] elem = r[i];
			System.out.print("[");
			for (int j = 0; j < elem.length; j++) {
				System.out.print(elem[j]);
				if (j < elem.length - 1) {
					System.out.print(",");
				}
			}
			System.out.print("]");
			if (i < r.length - 1) {
				System.out.print(",");
			}
		}
		System.out.println("]");
	}

	public static void printArray2D(int[][] r, String title) {
		System.out.println(title + ": [");
		for (int i = 0; i < r.length; i++) {
			int[] elem = r[i];
			System.out.print("[");
			for (int j = 0; j < elem.length; j++) {
				System.out.print(String.format("%3d", elem[j]));
				if (j < elem.length - 1) {
					System.out.print(",");
				}
			}
			System.out.print("]");
			if (i < r.length - 1) {
				System.out.println("");
			}
		}
		System.out.println("]");
	}

	public static void printArray2D(boolean[][] r, String title) {
		System.out.println(title + ": [");
		for (int i = 0; i < r.length; i++) {
			boolean[] elem = r[i];
			System.out.print("[");
			for (int j = 0; j < elem.length; j++) {
				System.out.print(elem[j] ? "V" : "-");
				if (j < elem.length - 1) {
					System.out.print(",");
				}
			}
			System.out.print("]");
			if (i < r.length - 1) {
				System.out.println("");
			}
		}
		System.out.println("]");
	}

	public static void main(String[] args) {
		long l = 0L;
		for (long i = 0; i < 64; i++) {
			l |= 1L << i;
			System.out.println(i);
			printLongAsBinary(l);
		}
	}
}
