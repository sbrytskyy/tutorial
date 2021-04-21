package com.sb.test.collections;

import java.util.Collections;
import java.util.PriorityQueue;

public class PriorityQueueDemo {

	public static void priorityQueueTest() {
		System.out.println("PriorityQueue");
		// Creating empty priority queue
		PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>();

		// Adding items to the pQueue using add()
		pQueue.add(10);
		pQueue.add(20);
		pQueue.add(15);
		pQueue.add(5);

		// Printing the top element of PriorityQueue
		System.out.println(pQueue.peek());

		// Printing the top element and removing it
		// from the PriorityQueue container
		System.out.println(pQueue.poll());

		// Printing the top element again
		System.out.println(pQueue.peek());
	}

	public static void recersePriorityQueueTest() {
		System.out.println("Reverse PriorityQueue");
		// Creating empty priority queue
		PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>(
				Collections.reverseOrder());

		// Adding items to the pQueue using add()
		pQueue.add(10);
		pQueue.add(20);
		pQueue.add(15);
		pQueue.add(5);

		// Printing the top element of PriorityQueue
		System.out.println(pQueue.peek());

		// Printing the top element and removing it
		// from the PriorityQueue container
		System.out.println(pQueue.poll());

		// Printing the top element again
		System.out.println(pQueue.peek());
	}

	public static void main(String[] args) {
		priorityQueueTest();
		recersePriorityQueueTest();
	}
}
