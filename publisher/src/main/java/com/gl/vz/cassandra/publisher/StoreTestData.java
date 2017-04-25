package com.gl.vz.cassandra.publisher;

import java.util.Random;

import org.apache.log4j.Logger;

import com.datastax.driver.core.BoundStatement;
import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.PreparedStatement;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Session;

public class StoreTestData {
	public static void main(String args[]) {

		final Logger logger = Logger.getLogger(StoreTestData.class.getName());

		// Query
		String query = "CREATE KEYSPACE tp WITH replication " + "= {'class':'SimpleStrategy', 'replication_factor':1};";

		// creating Cluster object
		Cluster cluster = Cluster.builder().addContactPoint("68.128.180.159").build();

		// Creating Session object
		Session session = cluster.connect();

		try {
			// Executing the query
			session.execute(query);
			System.out.println("Keyspace created");
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

		// using the KeySpace
		session.execute("USE tp");
		System.out.println("Keyspace TP used");
		// Query
		query = "CREATE TABLE message(msg_id int PRIMARY KEY, msg_text text, device_id text );";

		try {
			// Executing the query
			session.execute(query);
			System.out.println("Table created");
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

		Random r = new Random();
		PreparedStatement ps = session.prepare("INSERT INTO message (msg_id, msg_text, device_id)" + "VALUES(?,?,?)");

		for (int i = 0; i < 10000000; i++) {

			int deviceId = Math.abs(r.nextInt());

			String message = "Test Message " + String.format("%012d", deviceId);

			// queries
			// query = "INSERT INTO message (msg_id, msg_text, device_id)"
			// + "VALUES(" + deviceId + ",'" + message + "', 'Device" + deviceId
			// + "');";
			//
			// Executing the query
			// session.execute(query);

			BoundStatement bound = ps.bind(deviceId, message, "Device" + deviceId);

			try {
				session.execute(bound);
			} catch (Exception ex) {
				logger.error(ex.getMessage());
				session.close();
				session = cluster.connect();
			}

			if (i % 100 == 0) {
				logger.info(" [x] Stored '" + message + "'");
			}
		}

		System.out.println("Data created");

		// // queries
		// query = "SELECT * FROM message";
		// // Getting the ResultSet
		// ResultSet result = session.execute(query);
		//
		// System.out.println(result.all());

		query = "SELECT COUNT(*) FROM message;";
		// Getting the ResultSet
		ResultSet resultCount = session.execute(query);

		System.out.println(resultCount.all());

		session.close();
		cluster.close();
	}
}
