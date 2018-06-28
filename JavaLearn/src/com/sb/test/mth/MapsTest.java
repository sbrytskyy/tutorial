package com.sb.test.mth;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MapsTest {
//	private static Map<String, List<String>> synchronizedMap = Collections
//			.synchronizedMap(new HashMap<String, List<String>>());

	private static Map<String, List<String>> synchronizedMap = new ConcurrentHashMap<String, List<String>>();

	public void doWork(String key) {
		List<String> values = null;
		while ((values = synchronizedMap.remove(key)) != null) {
			// do something with values
			System.out.println("Values: " + String.join(", ", values));
		}
	}

	public static void addToMap(String key, String value) {
		synchronized (synchronizedMap) {
			if (synchronizedMap.containsKey(key)) {
				synchronizedMap.get(key).add(value);
			} else {
				List<String> valuesList = new ArrayList<String>();
				valuesList.add(value);
				synchronizedMap.put(key, valuesList);
			}
		}
	}
	
	public void test() {
		addToMap("key1", "v11");
		addToMap("key1", "v12");
		addToMap("key1", "v13");
		addToMap("key2", "v21");
		addToMap("key2", "v22");
		addToMap("key3", "v31");
		
		doWork("key2");
	}
	
	public static void main(String[] args) {
		MapsTest mt = new MapsTest();
		mt.test();
	}
}
