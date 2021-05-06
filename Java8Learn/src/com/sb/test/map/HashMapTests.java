package com.sb.test.map;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class HashMapTests {

	public Map<String, Integer> buildMap() {
		Map<String, Integer> map = new HashMap<>();
		map.put("E", 2);
		map.put("B", 14);
		map.put("D", 5);
		map.put("A", 7);
		map.put("F", 5);
		map.put("C", 1);
		return map;
	}

	public Map<String, Integer> sortMapByValue(Map<String, Integer> map) {

		Map<String, Integer> sorted = map.entrySet().stream()
				.sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
				.collect(Collectors.toMap(
						Map.Entry::getKey,
						Map.Entry::getValue,
						(e1, e2) -> e1, LinkedHashMap::new));

		return sorted;
	}

	public static void main(String[] args) {
		HashMapTests sol = new HashMapTests();
		Map<String, Integer> map = sol.buildMap();
		System.out.println("Unsorted: " + map);
		Map<String, Integer> sortedByValue = sol.sortMapByValue(map);
		System.out.println("  Sorted: " + sortedByValue);
	}

}
