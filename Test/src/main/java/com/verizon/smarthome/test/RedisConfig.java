//package com.verizon.smarthome.nest.multiplex.manager.service.impl;
//
//import org.redisson.Redisson;
//import org.redisson.api.RedissonClient;
//import org.redisson.codec.KryoCodec;
//import org.redisson.config.Config;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import lombok.extern.slf4j.Slf4j;
//
//@Slf4j
//@Configuration
//public class RedisConfig {
//	
//	@Value("${redis.host}")
//	private String redisHost;
//	
//	@Value("${redis.useLinuxNativeEpoll}")
//	private boolean useLinuxNativeEpoll;
//
//	@Bean
//	public RedissonClient getRedissonClient() {
//		log.info("[getRedissonClient] Redis Host:" + redisHost);
//
//		Config config = new Config();
//		config.setUseLinuxNativeEpoll(useLinuxNativeEpoll);
//		config.setCodec(new KryoCodec());
//		config.useSingleServer().setAddress(redisHost);
//
//		RedissonClient client = Redisson.create(config);
//		
//		return client;
//	}
//}
