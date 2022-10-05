package org.java.collection;

import java.util.PriorityQueue;

/**
 * Use Java PriorityQueue as Heap
 */
public class MinHeap {
	public static void main(String[] args) {
		PriorityQueue<Integer> meanHeap = new PriorityQueue<Integer>();
		//Keeps the minimum element on top
		meanHeap.add(10);
		meanHeap.add(9);
		meanHeap.add(12);
		meanHeap.add(7);// TIME: O(logN)

		System.out.println(meanHeap);// [7, 9, 12, 10]
		System.out.println(meanHeap.peek());
		// 7 returns top element without removing it from heap. TIME: O(1)
		System.out.println(meanHeap.poll());// 7 removes top element TIME: O(logN)
		System.out.println(meanHeap);// [9, 10, 12]
	}
}
