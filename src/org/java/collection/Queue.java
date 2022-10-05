package org.java.collection;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * FIFO(First-in-first-out) data structure
 * - Ordered list of objects
 * <p>
 * Important APIs(LinkedList):
 * - add(e)     : Adds e element in the queue(in the front), returns true if successful, false or throw exception if failed.
 * - offer(e)   : Adds e element in the queue(in the front), returns true if successful, false otherwise.
 * - poll()     : removes and returns element from top/front
 * - element()  : returns element from top/front. throws exception if queue is empty.
 * - peek()     : returns element from top/front. returns null if queue is empty.
 */
public class Queue {
	public static void main(String[] args) {
		java.util.Queue<Integer> bucket1 = new LinkedList<>();
		bucket1.add(12);
		bucket1.add(11);
		bucket1.add(13);

		System.out.println("--LinkedList impl queue");
		System.out.println(bucket1);
		System.out.println(bucket1.poll());
		System.out.println(bucket1.poll());
		System.out.println(bucket1);


		System.out.println("--PriorityQueue impl queue");
		java.util.Queue<Integer> bucket2 = new PriorityQueue<Integer>();
		bucket2.add(12);
		bucket2.add(11);
		bucket2.add(13);
		System.out.println(bucket2);
		bucket2.offer(1234);
		System.out.println(bucket2);
		System.out.println(bucket2.poll());
		System.out.println(bucket2);

		Iterator<Integer> itr = bucket2.iterator();
		while (itr.hasNext()) System.out.println(itr.next() + "-");
		while (!bucket2.isEmpty()) {
			System.out.println("->"+bucket2.poll());
		}
	}
}
