package rabbit.subscriber;

import com.rabbitmq.client.*;

import java.io.IOException;

public class ReceiveMessages {
	private static final String EXCHANGE_NAME = "vz/iot/lwm2m";

	public static void main(String[] argv) throws Exception {
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		Connection connection = factory.newConnection();
		final Channel channel = connection.createChannel();

		channel.exchangeDeclare(EXCHANGE_NAME, "fanout");
		String queueName = channel.queueDeclare().getQueue();
		channel.queueBind(queueName, EXCHANGE_NAME, "");

		System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

		Consumer consumer = new DefaultConsumer(channel) {
			@Override
			public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties,
					byte[] body) throws IOException {
				long deliveryTag = envelope.getDeliveryTag();
	            // (process the message components here ...)
				String message = new String(body, "UTF-8");
				System.out.println(" [x] Received '" + message + "'");
				channel.basicAck(deliveryTag, false);
			}
		};
		channel.basicConsume(queueName, false, consumer);
	}
}