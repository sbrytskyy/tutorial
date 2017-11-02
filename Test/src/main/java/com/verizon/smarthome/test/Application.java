package com.verizon.smarthome.test;

import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.codec.KryoCodec;
import org.redisson.config.Config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import redis.clients.jedis.Jedis;

@Slf4j
public class Application {

	public static void main(String[] args) throws URISyntaxException {
		// resolveHostTest();
		// testStreams();

		// testRedis();

		// testMapRedisson();

		// testMapRedis();

		// testMapSorting();
		
		justTest();
	}

	private static void justTest() {
		int newTokensCount = 50000;
		int totalNodeSize = 1000;
		
		if (newTokensCount < 50 || newTokensCount < totalNodeSize / 2) {
			System.out.println("Passed");
		} else {
			System.out.println("Failed");
		}
		
	}

	private static void testMapRedis() {
		RedisUtils ru = new RedisUtils();

		String mapName = "tokensForNodes";
		// Map<String, Set<String>> map = new ConcurrentHashMap<>();
		// Set<String> s1 = new HashSet<>();
		// s1.add("1");
		// s1.add("2");
		// s1.add("3");
		// map.put("192.168.0.1", s1);
		// Set<String> s2 = new HashSet<>();
		// s2.add("4");
		// s2.add("5");
		// map.put("192.168.0.2", s2);
		// Set<String> s3 = new HashSet<>();
		//// s3.add("6");
		//// s3.add("7");
		// map.put("192.168.0.3", s3);
		//
		// System.out.println("[SB] map init ----------------------");
		// map.entrySet().stream().forEach(e -> System.out.println("\t{} -> [{}]",
		// e.getKey(), String.join(",", e.getValue())));
		//
		// ru.storeHashMap(mapName, map);

		// String mapName = "tokensForNodes";
		Map<String, Set<String>> map2 = ru.retrieveHashMap(mapName);

		System.out.println("[SB] map 2 ----------------------: " + map2.size());
		for (String key : map2.keySet()) {
			Set<String> set = map2.get(key);
			System.out.format("\t{} -> [{}]", key, String.join(",", set));
		}
		map2.entrySet().stream().forEach(e -> System.out.println(e.toString()));
		System.out.println("[SB] ----------------------------");

	}

	private static void testMapSorting() {

		Map<String, Set<String>> map = new ConcurrentHashMap<>();
		Set<String> s1 = new HashSet<>();
		s1.add("1");
		s1.add("2");
		s1.add("3");
		map.put("192.168.0.1", s1);
		Set<String> s2 = new HashSet<>();
		s2.add("4");
		s2.add("5");
		map.put("192.168.0.2", s2);
		Set<String> s3 = new HashSet<>();
		// s3.add("6");
		// s3.add("7");
		map.put("192.168.0.3", s3);

		System.out.println("[SB] map init ----------------------");
		map.entrySet().stream().forEach(e -> System.out.format("\t{} -> [{}]", e.getKey(), String.join(",", e.getValue())));

		String leastLoadedNode = findLeastLoadedNode(map);
		System.out.println("[SB] leastLoadedNode: " + leastLoadedNode);
		
		int totalNodeSize = findTotalNodeSize(map);
		System.out.println("[SB] totalNodeSize: " + totalNodeSize);
	}

	public static <K, V extends Collection<?>> int findTotalNodeSize(Map<K, V> map) {

		int sum = map.entrySet().stream().mapToInt(e -> e.getValue().size()).sum();
		return sum;
	}

	public static <K, V extends Collection<?>> K findLeastLoadedNode(Map<K, V> map) {

		Map<K, Integer> ms = map.entrySet().stream()
				.collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue().size()));

		ms = ms.entrySet().stream().sorted(Map.Entry.comparingByValue())
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

		return ms.entrySet().iterator().next().getKey();
	}

	private static void testMapRedisson() {
		Config config = new Config();
		config.setCodec(new KryoCodec());
		config.useSingleServer().setAddress("redis://127.0.0.1:6379");

		RedissonClient client = Redisson.create(config);

		RedisUtils ru = new RedisUtils(client);

		String mapName = "tokensForNodes";
		Map<String, Set<String>> map = new ConcurrentHashMap<>();
		Set<String> s1 = new HashSet<>();
		s1.add("1");
		s1.add("2");
		s1.add("3");
		map.put("192.168.0.1", s1);
		Set<String> s2 = new HashSet<>();
		s2.add("4");
		s2.add("5");
		map.put("192.168.0.2", s2);
		Set<String> s3 = new HashSet<>();
		// s3.add("6");
		// s3.add("7");
		map.put("192.168.0.3", s3);

		System.out.println("[SB] map init ----------------------");
		map.entrySet().stream().forEach(e -> System.out.format("\t{} -> [{}]", e.getKey(), String.join(",", e.getValue())));

		ru.storeHashMap(mapName, map);

		// String mapName = "tokensForNodes";
		Map<String, Set<String>> map2 = ru.retrieveHashMap(mapName);

		System.out.println("[SB] map 2 ----------------------: " + map2.size());
		for (String key : map2.keySet()) {
			Set<String> set = map2.get(key);
			System.out.format("\t{} -> [{}]", key, String.join(",", set));
		}
		map2.entrySet().stream().forEach(e -> System.out.println(e.toString()));
		System.out.println("[SB] ----------------------------");

		client.shutdown();
	}

	private static void testRedis() {
		// Connecting to Redis server on localhost
		Jedis jedis = new Jedis("localhost");
		System.out.println("Connection to server sucessfully");
		// check whether server is running or not
		System.out.println("Server is running: " + jedis.ping());

		// set the data in redis string
		jedis.set("tutorial-name", "Redis tutorial");
		// Get the stored data and print it
		System.out.println("Stored string in redis:: " + jedis.get("tutorial-name"));

		// store data in redis list
		jedis.lpush("tutorial-list", "Redis");
		jedis.lpush("tutorial-list", "Mongodb");
		jedis.lpush("tutorial-list", "Mysql");
		// Get the stored data and print it
		List<String> list = jedis.lrange("tutorial-list", 0, 5);

		for (int i = 0; i < list.size(); i++) {
			System.out.println("Stored string in redis:: " + list.get(i));
		}

		// store data in redis list
		// Get the stored data and print it
		Set<String> keys = jedis.keys("*");

		keys.stream().forEach(e -> System.out.println("Key: " + e));
	}

	private static void resolveHostTest() throws URISyntaxException {
		String multiplexNestUrl = "https://developer-api.nest.com/multiplex";
		int multiplexNestPort = 443;

		URI uri = URI.create(multiplexNestUrl);
		uri = new URI(uri.getScheme(), uri.getUserInfo(), uri.getHost(), multiplexNestPort, uri.getPath(),
				uri.getQuery(), uri.getFragment());

		String nest = uri.toString();
		System.out.println(nest);
		String hostIP = new Application().resolveHostIP(nest);
		System.out.println(hostIP);
	}

	private String resolveHostIP(String urlString) {
		try {
			URL url = new URL(urlString);
			InetAddress address = InetAddress.getByName(url.getHost());
			String hostAddress = address.getHostAddress();
			if (hostAddress != null && !hostAddress.isEmpty()) {
				String newUrl = urlString.replace(url.getHost(), hostAddress);
				return newUrl;
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void testStreams() {
		List<ConnectedSensorDTO> sensors = new ArrayList<>();

		sensors.add(null);

//		sensors.stream().filter(Objects::nonNull)
//				.collect(Collectors.toMap(ConnectedSensorDTO::getSerial,
//						sensor -> sensor.getProperties().stream()
//								.collect(Collectors.toMap(PropertyDTO::getName, PropertyDTO::getValue))))
//				.entrySet().forEach(entry -> {
//					System.out.format("[processSuccess] key: {}; value: {}", entry.getKey(), entry.getValue());
//				});
	}
}

@Getter
@Setter
@AllArgsConstructor
class PropertyDTO {

	private String name;

	private String value;

}

@Getter
@Setter
@NoArgsConstructor
class ConnectedSensorDTO {

	private String name;

	private String serial;

	private List<PropertyDTO> properties = new ArrayList<>();

	public ConnectedSensorDTO(String name, String serial) {
		this.serial = serial;
		this.name = name;
		this.properties = new ArrayList<>();
	}

	public void addProperty(PropertyDTO propertyDTO) {
		this.properties.add(propertyDTO);
	}
}
