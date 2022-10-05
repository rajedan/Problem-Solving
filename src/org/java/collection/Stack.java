package org.java.collection;

import java.util.Iterator;

/**
 * LIFO(Last-in-first-out) Data Structure
 *
 * Important APIs:
 * - push(e)
 * - pop() - returns top element and removes it
 * - peek() - returns top element
 */
public class Stack {

	public static void main(String[] args) {
		java.util.Stack<String> stack = new java.util.Stack<>();
		stack.push("Hi");
		stack.push("hello");
		stack.push("there");
		stack.push("world");

		Iterator<String> itr = stack.iterator();
		while (itr.hasNext())
			System.out.println(itr.next());
		System.out.println(stack);
		System.out.println(stack.pop());
	}
}
