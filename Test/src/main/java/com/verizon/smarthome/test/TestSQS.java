package com.verizon.smarthome.test;

import java.util.List;
import java.util.Map.Entry;

import com.amazonaws.AmazonClientException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClient;
import com.amazonaws.services.sqs.model.CreateQueueRequest;
import com.amazonaws.services.sqs.model.DeleteMessageRequest;
import com.amazonaws.services.sqs.model.DeleteQueueRequest;
import com.amazonaws.services.sqs.model.Message;
import com.amazonaws.services.sqs.model.ReceiveMessageRequest;
import com.amazonaws.services.sqs.model.SendMessageRequest;

public class TestSQS {

	private static final String ACCESS_KEY = "AKIAIPY5DL7QU5L5M5XQ";
	private static final String SECRET_KEY = "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";
	
	private AmazonSQS sqs;
	private String myQueueUrl;
	
    private BasicAWSCredentials getAwsCredentials() {
        return new BasicAWSCredentials(ACCESS_KEY, SECRET_KEY);
    }

	
	public void init() {
		/*
         * The ProfileCredentialsProvider returns your [default]
         * credential profile by reading from the credentials file located at
         * (~/.aws/credentials).
         */
        AWSCredentials credentials = null;
        try {
            credentials = getAwsCredentials();
        } catch (Exception e) {
            throw new AmazonClientException(
                    "Cannot load the credentials from the credential profiles file. " +
                    "Please make sure that your credentials file is at the correct " +
                    "location (~/.aws/credentials), and is in valid format.",
                    e);
        }

        sqs = new AmazonSQSClient(credentials);
        Region usWest1 = Region.getRegion(Regions.US_WEST_1);
        sqs.setRegion(usWest1);

        System.out.println("===========================================");
        System.out.println("Getting Started with Amazon SQS");
        System.out.println("===========================================\n");
        
     // List queues
        System.out.println("Listing all queues in your account.\n");
        for (String queueUrl : sqs.listQueues().getQueueUrls()) {
            System.out.println("  QueueUrl: " + queueUrl);
        }
        System.out.println();
	}
	
	public void createQueue() {
		// Create a queue
		System.out.println("Creating a new SQS queue called MyQueue.\n");
		CreateQueueRequest createQueueRequest = new CreateQueueRequest().withQueueName("sqsTest1");
		myQueueUrl = sqs.createQueue(createQueueRequest).getQueueUrl();
	}
	
	public void getQueue() {
		// Create a queue
		System.out.println("Retrieving SQS queue called sqsTest1.\n");
		myQueueUrl = sqs.getQueueUrl("sqsTest1").getQueueUrl();
	}
	
	public void testSend() {
		// Send a message
        System.out.println("Sending a message to MyQueue.\n");
        sqs.sendMessage(new SendMessageRequest(myQueueUrl, "This is my message text."));
	}

	public List<Message> testReceive() {
        // Receive messages
        System.out.println("Receiving messages from MyQueue.\n");
        ReceiveMessageRequest receiveMessageRequest = new ReceiveMessageRequest(myQueueUrl);
        List<Message> messages = sqs.receiveMessage(receiveMessageRequest).getMessages();
        for (Message message : messages) {
            System.out.println("  Message");
            System.out.println("    MessageId:     " + message.getMessageId());
            System.out.println("    ReceiptHandle: " + message.getReceiptHandle());
            System.out.println("    MD5OfBody:     " + message.getMD5OfBody());
            System.out.println("    Body:          " + message.getBody());
            for (Entry<String, String> entry : message.getAttributes().entrySet()) {
                System.out.println("  Attribute");
                System.out.println("    Name:  " + entry.getKey());
                System.out.println("    Value: " + entry.getValue());
            }
        }
        System.out.println();
        
        return messages;
	}
	
	public void deleteMessage(List<Message> messages) {
		if (messages.isEmpty()) return;
		
        // Delete a message
        System.out.println("Deleting a message.\n");
        String messageReceiptHandle = messages.get(0).getReceiptHandle();
        sqs.deleteMessage(new DeleteMessageRequest(myQueueUrl, messageReceiptHandle));
	}
	
	public void deleteQueue() {
        // Delete a queue
        System.out.println("Deleting the test queue.\n");
        sqs.deleteQueue(new DeleteQueueRequest(myQueueUrl));
	}

	public static void main(String[] args) {
		TestSQS t = new TestSQS();
		t.init();
		
		//t.createQueue();
		
		t.getQueue();
		//t.testSend();
		List<Message> msgs = t.testReceive();
		//t.deleteMessage(msgs);
		
		//t.deleteQueue();
	}
	
}
