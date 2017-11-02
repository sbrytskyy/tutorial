package com.verizon.smarthome.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.redisson.api.RMap;
import org.redisson.api.RSet;
import org.redisson.api.RedissonClient;

import lombok.extern.slf4j.Slf4j;
import redis.clients.jedis.Jedis;

@Slf4j
public class RedisUtils {
	
	private RedissonClient client;
	
	public RedisUtils(RedissonClient client) {
		this.client = client;
	}
	
	private Jedis jedis;
	
	public RedisUtils() {
//		log.debug("[SB] RedisStorageImpl::CTOR");
		jedis = new Jedis("localhost");
	}
	

//	public static void storeHashMap(RedissonClient client, String mapName, Map<String, Set<String>> map) {
//		RMap<String, Set<String>> rmap = client.getMap(mapName);
//		map.entrySet().stream().forEach(e -> rmap.put(e.getKey(), e.getValue()));
//	}
//
//	public static Map<String, Set<String>> retrieveHashMap(RedissonClient client, String mapName) {
//		Map<String, Set<String>> map = new HashMap<>();
//		
//		RMap<String, Set<String>> rmap = client.getMap(mapName);
//		rmap.entrySet().stream().forEach(e -> map.put(e.getKey(), e.getValue()));
//
//		return map;
//	}
//
//	public static synchronized void storeHashMap(RedissonClient client, String mapName, Map<String, Set<String>> map) {
//		log.debug("[SB] RedisStorageImpl::storeHashMap");
//		RSet<String> rsetKeys = client.getSet(mapName);
//		rsetKeys.clear();
//		
//		map.entrySet().stream().forEach(e -> System.out.println(e.getKey() + ":" + e.getValue()));
//		Set<String> keySet = map.keySet();
//		for (String key : keySet) {
//			Set<String> set = map.get(key);
//			rsetKeys.add(key);
//			
//			RSet<String> rsetValues = client.getSet(key);
//			rsetValues.clear();
//			set.stream().forEach(e -> rsetValues.add(e));
//		}
//	}
//
//	public static synchronized Map<String, Set<String>> retrieveHashMap(RedissonClient client, String mapName) {
//		log.debug("[SB] RedisStorageImpl::retrieveHashMap");
//		Map<String, Set<String>> map = new HashMap<>();
//
//		RSet<String> rsetKeys = client.getSet(mapName);
//		for (String key: rsetKeys) {
//			RSet<String> rsetValues = client.getSet(key);
//			map.put(key, rsetValues);
//		}
////
//		return map;
//	}
	
	
//	public synchronized void storeHashMap(String mapName, Map<String, Set<String>> map) {
//		log.debug("[SB] RedisStorageImpl::storeHashMap");
//		RMap<String, Set<String>> rmap = client.getMap(mapName);
//		rmap.clear();
//		rmap.putAll(map);
//	}
//
//	public synchronized Map<String, Set<String>> retrieveHashMap( String mapName) {
//		log.debug("[SB] RedisStorageImpl::retrieveHashMap");
//		RMap<String, Set<String>> rmap = client.getMap(mapName);
//		return rmap;
//	}
//
	
	public synchronized void storeHashMap(String mapName, Map<String, Set<String>> map) {
//		log.debug("[SB] RedisStorageImpl::storeHashMap");
		
		jedis.del(mapName); // clear if exists
		for (String key: map.keySet()) {
			jedis.del(key);
			for (String value: map.get(key)) {
				jedis.sadd(key, value);
			}
			jedis.sadd(mapName, key);
		}
	}

	public synchronized Map<String, Set<String>> retrieveHashMap(String mapName) {
//		log.debug("[SB] RedisStorageImpl::retrieveHashMap");
		Map<String, Set<String>> map = new HashMap<>();

		Set<String> keys = jedis.smembers(mapName);
		for(String key: keys) {
			Set<String> values = jedis.smembers(key);
			map.put(key, values);
		}
		return map;
	}


}
