package com.sb.test.mem;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class MemoryTest {

	public Map<String, Integer> countWordsFromFile(String filename) {
		Map<String, Integer> wordCounter = new HashMap<>();

		int counter = 0;
		try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
			String line;
			while ((line = br.readLine()) != null) {
				counter++;

				String[] words = line.split("\\W+");
				for (String word : words) {
					if (word.length() > 0) {
						int c = wordCounter.getOrDefault(word, 0);
						wordCounter.put(word, c + 1);
					}
				}

				if (counter % 1000000 == 0) {
					System.out.println("Lines read: " + counter);
				}
				if (counter == 13000000) {
					// break;
				}
			}
		} catch (IOException e) {
		}
		System.out.println("Lines read: " + counter);
		return wordCounter;
	}

	public void memtest() {
		printMemory();

		String filename = "enwiki-latest-abstract-huge.xml";
		Map<String, Integer> countWords = countWordsFromFile(filename);
		System.out.println("Unique words: " + countWords.size());

		Map<String, Integer> sortedMap = countWords.entrySet().stream()
				.sorted(Entry.comparingByValue(Comparator.reverseOrder()))
				.limit(15)
				.collect(Collectors.toMap(Entry::getKey, Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

		System.out.println(sortedMap);

		printMemory();
	}

	private void printMemory() {
		System.out.println("/--------------------------------------------/");
		System.out.println(
				String.format("\tTotal: %d Gb, free: %d Gb",
						Runtime.getRuntime().totalMemory() / 1024 / 1024,
						Runtime.getRuntime().freeMemory() / 1024 / 1024));
		System.out.println("/--------------------------------------------/");
	}

	public static void main(String[] args) {
		MemoryTest mt = new MemoryTest();
		mt.memtest();
	}
}
