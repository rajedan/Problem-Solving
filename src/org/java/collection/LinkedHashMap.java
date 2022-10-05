package org.java.collection;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * LinkedHashMap Collection in Java
 * Details:
 * - It implements Map interface and extends HashMap class.
 * - maintains insertion order of elements
 * - one null key is allowed. Multiple null values are allowed.
 * - it is non-synchronised
 * - values are stored in the form of nodes
 * - Each node has a structure similar to Doubly linked list
 *
 * Important APIs:
 * - put(key, value)
 * - entrySet() return Set<Map.Entry<K, V>> which helps to iterate through each element
 * - containsValue(obj) true if obj is mapped with any key
 * - keySet() returns Set<K>
 * - values() returns Collection<V> containing all the values
 * - containsKey(obj) returns true if obj is one of the key
 */
public class LinkedHashMap {
	public static void main(String[] args) {
		java.util.LinkedHashMap<String, Integer> bucket = new java.util.LinkedHashMap<String, Integer>();

		bucket.put("one", 1);
		bucket.put("two", 2);
		bucket.put("three", 9);
		bucket.put("four", 4);

		System.out.println(bucket);

		Set<Map.Entry<String, Integer>> itr = bucket.entrySet();
		for (Map.Entry<String, Integer> e : itr) {
			if (e.getKey().equals("two")) {
				System.out.println("found");
				e.setValue(9);
			}
			System.out.println(e.getKey() + " - " + e.getValue());
		}

		Set<String> es = bucket.keySet();
		for(String key: es)
			System.out.println(key);

		Collection<Integer> vs = bucket.values();
		for(Integer i: vs)
			System.out.println(i);

	}
}
