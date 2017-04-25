package com.gl.vz.cassandra.publisher;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import org.apache.log4j.Logger;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Session;

public class ReadTestData {
	public static void main(String args[]) {

		final Logger logger = Logger.getLogger(ReadTestData.class.getName());

		// creating Cluster object
		Cluster cluster = Cluster.builder().addContactPoint("68.128.180.159").build();

		// Creating Session object
		final Session session = cluster.connect();

		// using the KeySpace
		session.execute("USE tp");
		System.out.println("Keyspace TP used");

		Timer t = new Timer();
		TimerTask task = new TimerTask() {

			@Override
			public void run() {
				String query = "SELECT COUNT(*) FROM message;";
				// Getting the ResultSet
				try {
					ResultSet resultCount = session.execute(query);

					logger.info(resultCount.all());
				} catch (Exception ex) {
					logger.error(ex.getMessage());
				}
			}

		};
		t.schedule(task, new Date(), 1000);

		for (;;) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				break;
			}
		}

		session.close();
		cluster.close();
	}
}
