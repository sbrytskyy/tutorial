package com.gl.vz.mqtt;

import java.util.Random;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

public class MqttPublish {

	public static void main(String[] args) {

		Random r = new Random();
		String topic = "vz/iot/lwm2m";
		int qos = 1;
		String broker = "tcp://localhost:1883";
		String clientId = "JavaSample";
		MemoryPersistence persistence = new MemoryPersistence();

		try {
			MqttClient client = new MqttClient(broker, clientId, persistence);
			MqttConnectOptions connOpts = new MqttConnectOptions();
			connOpts.setCleanSession(true);
			System.out.println("Connecting to broker: " + broker);
			client.connect(connOpts);
			System.out.println("Connected");

			MqttMessage msg = new MqttMessage(new byte[0]);
			msg.setRetained(true);
			// client.publish(topic, msg);

			for (int i = 0; i < 10000; i++) {
				String content = "Test Mqtt Message " + String.format("%10d", r.nextInt());
				System.out.println("Publishing message: " + content);
				MqttMessage message = new MqttMessage(content.getBytes());
				message.setQos(qos);
				// message.setRetained(true);
				client.publish(topic, message);
				System.out.println("Message published");
			}
			client.disconnect();
			System.out.println("Disconnected");
			System.exit(0);
		} catch (MqttException me) {
			System.out.println("reason " + me.getReasonCode());
			System.out.println("msg " + me.getMessage());
			System.out.println("loc " + me.getLocalizedMessage());
			System.out.println("cause " + me.getCause());
			System.out.println("excep " + me);
			me.printStackTrace();
		}
	}
}