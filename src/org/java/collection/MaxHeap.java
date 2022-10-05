package org.java.collection;

import java.util.Collections;
import java.util.PriorityQueue;

public class MaxHeap {

	public static void main(String[] args) {
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
		//Max heap: keeps the max element on top

		maxHeap.offer(30);
		maxHeap.offer(3);
		maxHeap.offer(20);
		maxHeap.offer(80); // TIME: O(logN)

		System.out.println(maxHeap);
		System.out.println(maxHeap.peek()); // TIME: O(1)

		//Above is same as below:
		PriorityQueue<Integer> maxHeap2 = new PriorityQueue<Integer>((Integer o1, Integer o2) -> Integer.compare(o2, o1));
		maxHeap2.offer(30);
		maxHeap2.offer(3);
		maxHeap2.offer(20);
		maxHeap2.offer(80); // TIME: O(logN)
		System.out.println(maxHeap2);
		System.out.println(maxHeap2.peek()); // TIME: O(1)
	}
}
