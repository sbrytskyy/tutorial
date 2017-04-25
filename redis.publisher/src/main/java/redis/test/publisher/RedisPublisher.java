package redis.test.publisher;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;

public class RedisPublisher {

	public static void main(String[] args) {
		// Connecting to Redis server on localhost
		Jedis jedis = new Jedis("68.128.180.159", 6379);
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
		HashSet<String> set = (HashSet<String>) jedis.keys("*");

		for (Iterator<String> it = set.iterator(); it.hasNext();) {
			System.out.println("List of stored keys:: " + it.next());
		}

		// lets do some stress
		Pipeline pipeline = jedis.pipelined();
		
		Random r = new Random();
		for (int i = 0; i < 24000000; i++) {
			String message = "Test Redis Message " + String.format("%010d", Math.abs(r.nextInt()));

			pipeline.lpush("vz/iot/lwm2m", message);
			if (i % 10000 == 0) {
				System.out.println(" [x] Sent '" + message + "'");
			}
		}
		pipeline.sync();

		Long llen = jedis.llen("vz/iot/lwm2m");
		System.out.println("Stored items in redis list:: " + llen);

		jedis.close();
	}
}
