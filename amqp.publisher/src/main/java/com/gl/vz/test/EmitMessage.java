package com.gl.vz.test;

import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;

import java.util.Random;

import com.rabbitmq.client.Channel;

public class EmitMessage {

	private static final String EXCHANGE_NAME = "vz/iot/lwm2m";

	public static void main(String[] argv) throws Exception {
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();

		channel.exchangeDeclare(EXCHANGE_NAME, "fanout");

		Random r = new Random();
		for (int i = 0; i < 10000; i++) {
			String message = "Test Ampq Message " + String.format("%10d", r.nextInt());

			channel.basicPublish(EXCHANGE_NAME, "", null, message.getBytes("UTF-8"));
			System.out.println(" [x] Sent '" + message + "'");
		}

		channel.close();
		connection.close();
	}
}