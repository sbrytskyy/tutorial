//package com.verizon.smarthome.nest.multiplex.manager.service.impl;
//
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Set;
//
//import javax.annotation.PreDestroy;
//
//import org.redisson.api.RMap;
//import org.redisson.api.RSet;
//import org.redisson.api.RedissonClient;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//import com.verizon.smarthome.nest.multiplex.manager.service.RedisStorage;
//
//import lombok.extern.slf4j.Slf4j;
//import redis.clients.jedis.Jedis;
//
//@Slf4j
//@Repository
//public class RedisStorageImpl implements RedisStorage {
//
////	private RedissonClient client;
//	
//	private Jedis jedis;
//	
//	@Autowired
//	public RedisStorageImpl(RedissonClient client) {
//		log.debug("[SB] RedisStorageImpl::CTOR");
//		jedis = new Jedis("localhost");
//	}
//	
////	@Autowired
////	public RedisStorageImpl(RedissonClient client) {
////		log.debug("[SB] RedisStorageImpl::CTOR. client: " + client);
////		this.client = client;
////	}
////
////	@Override
////	public synchronized void storeHashMap(String mapName, Map<String, Set<String>> map) {
////		log.debug("[SB] RedisStorageImpl::storeHashMap");
////		RMap<String, Set<String>> rmap = client.getMap(mapName);
////		rmap.clear();
////		rmap.putAll(map);
////	}
////
////	@Override
////	public synchronized Map<String, Set<String>> retrieveHashMap(String mapName) {
////		log.debug("[SB] RedisStorageImpl::retrieveHashMap");
////		RMap<String, Set<String>> rmap = client.getMap(mapName);
////		return rmap;
////	}
//
////	@Override
////	public synchronized void storeHashMap(String mapName, Map<String, Set<String>> map) {
////		log.debug("[SB] RedisStorageImpl::storeHashMap");
////		RSet<String> rsetKeys = client.getSet(mapName);
////		rsetKeys.clear();
////		
////		map.entrySet().stream().forEach(e -> System.out.println(e.getKey() + ":" + e.getValue()));
////		Set<String> keySet = map.keySet();
////		for (String key : keySet) {
////			Set<String> set = map.get(key);
////			rsetKeys.add(key);
////			
////			RSet<String> rsetValues = client.getSet(key);
////			rsetValues.clear();
////			set.stream().forEach(e -> rsetValues.add(e));
////		}
////	}
////
////	@Override
////	public synchronized Map<String, Set<String>> retrieveHashMap(String mapName) {
////		log.debug("[SB] RedisStorageImpl::retrieveHashMap");
////		Map<String, Set<String>> map = new HashMap<>();
////
////		RSet<String> rsetKeys = client.getSet(mapName);
////		for (String key: rsetKeys) {
////			RSet<String> rsetValues = client.getSet(key);
////			map.put(key, rsetValues);
////		}
//////
////		return map;
////	}
////
//
//	@Override
//	public synchronized void storeHashMap(String mapName, Map<String, Set<String>> map) {
//		log.debug("[SB] RedisStorageImpl::storeHashMap");
//		
//		jedis.del(mapName); // clear if exists
//		for (String key: map.keySet()) {
//			jedis.del(key);
//			for (String value: map.get(key)) {
//				jedis.sadd(key, value);
//			}
//			jedis.sadd(mapName, key);
//		}
//	}
//
//	@Override
//	public synchronized Map<String, Set<String>> retrieveHashMap(String mapName) {
//		log.debug("[SB] RedisStorageImpl::retrieveHashMap");
//		Map<String, Set<String>> map = new HashMap<>();
//
//		Set<String> keys = jedis.smembers(mapName);
//		for(String key: keys) {
//			Set<String> values = jedis.smembers(key);
//			map.put(key, values);
//		}
//		return map;
//	}
//
//	@PreDestroy
//    public void shutdown() {
////    	client.shutdown();
//    }
//}
