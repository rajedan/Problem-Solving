package org.java.collection;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.TreeSet;

/**
 * Set is an interface which stores unordered collection of unique elements.
 * TreeSet: It is a class which implements SortedSet. It contains ascending ordered unique element.
 * HashSet: insertion order is not maintained. null value is allowed.
 * LinkedHashSet: Ordered set of unique elements. Insertion order is maintained. It uses doubly linked-list to maintain elements.
 * EnumSet: works with enum of same type.
 */
public class Set {
	public static void main(String[] args) {
		java.util.Set<Integer> bucket = new HashSet<Integer>();
		bucket.add(20);
		bucket.add(10);
		bucket.add(30);
		bucket.add(15);
		System.out.println(bucket);

		java.util.Set<String> hs = new HashSet<String>();

		// Adding elements to above object
		// using add() method
		hs.add("B");
		hs.add("B");
		hs.add("C");
		hs.add("A");

		// Printing the elements inside the Set object
		System.out.println(hs);

		EnumSet<COLOR> colorBucket = EnumSet.of(COLOR.BLUE, COLOR.GREEN, COLOR.RED);
		System.out.println(colorBucket);

		java.util.Set<Integer> bucket1 = new LinkedHashSet<Integer>();
		bucket1.add(30);
		bucket1.add(3);
		bucket1.add(39);
		System.out.println(bucket1);
		Iterator<Integer> itr = bucket1.iterator();
		while (itr.hasNext()) System.out.println(itr.next());

		java.util.Set<Integer> bucket2 = new TreeSet<Integer>();
		bucket2.add(40);
		bucket2.add(1500);
		bucket2.add(800);
		System.out.println(bucket2);
	}
}

enum COLOR {
	RED, GREEN, BLUE, YELLOW
}
