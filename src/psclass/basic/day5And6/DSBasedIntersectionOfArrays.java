package psclass.basic.day5And6;

import java.util.Arrays;
import java.util.HashSet;

public class DSBasedIntersectionOfArrays {
	
	
	/**
	 * Adhoc approach : Brute Force/Naive based approach
	 * Time  : O(n^2)
	 * Space : O(1)
	 * @param in1
	 * @param in2
	 */
	private static int findIntersection1(int[] in1, int[] in2) {
		int common = 0;
		int m = in1.length, n = in2.length;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (in1[i] == in2[j]) {
					common++;
				}
			}
		}
		// TODO Bug Found : If in1 has 1,2,2 and in2 has 1,2 Then number of
		// common should be 2 NOT 3
		return common;
	}
	
	/**
	 * Sort+Scan Approach 
	 * Time  : O(mlogm+nlogm) : mlogm for sorting and nlogm
	 * for scaning
	 * Space : O(1)
	 * @param in1
	 * @param in2
	 * @return
	 */
	private static int findIntersection2(int[] in1, int[] in2) {
		int common = 0;
		int m = in1.length, n = in2.length;
		Arrays.sort(in1);
		for (int i = 0; i < n; i++) {
			if (Arrays.binarySearch(in1, in2[i]) >= 0) {
				common++;
			}
		}
		return common;
	}
	
	/**
	 * Double Sort + Scan Approach
	 * Time  : O(mlogm + nlogn) : mlogm and nlogn for sorting each array, 
	 * <=(m+n) for iterating over in1 and in2
	 * Space : O(1)
	 * @param in1
	 * @param in2
	 * @return
	 */
	private static int findIntersection3(int[] in1, int[] in2) {
		int common = 0;
		Arrays.sort(in1);
		Arrays.sort(in2);
		int m = in1.length, n = in2.length, i = 0,j = 0;
		while (i < m && j < n) {
			if (in1[i] == in2[j]) {
				common++;
				i++;
				j++;
			} else if (in1[i] < in2[j]) {
				i++;
			} else {
				j++;
			}
		}
		return common;
	}
	
	/**
	 * Using Data Structure as extra storage
	 * Time  : O(n) where n is size of in2 array
	 * Space : O(m) where m is size of in1 array
	 * Note : This method is useful when we eventually know the size of input arrays
	 * @param in1
	 * @param in2
	 * @return
	 */
	private static int findIntersection4(int[] in1, int[] in2) {
		int common = 0, n = in2.length;
		HashSet<Integer> set = new HashSet<Integer>();
		for (int i : in1) {
			set.add(i);
		}
		for (int i = 0; i < n; i++) {
			if (set.contains(in2[i])) {
				common++;
			}
		}
		return common;
	}
	
	/**
	 * https://leetcode.com/problems/intersection-of-two-arrays/description/
	 * Time  : O(m+n)
	 * Space : O(m) or O(n) whichever is minimum
	 * @param in1
	 * @param in2
	 * @return
	 */
	public static int[] intersection(int[] in1, int[] in2) {
		int m = in1.length, n = in2.length, flag = 0;
		int[] result = new int[m < n ? m : n];
		HashSet<Integer> set = new HashSet<Integer>();
		if (m < n) {
			for (int i = 0; i < m; i++) {
				set.add(in1[i]);
			}
			for (int i = 0; i < n; i++) {
				if (set.contains(in2[i])) {
					result[flag] = in2[i];
					flag++;
					set.remove(in2[i]);
				}
			}
		} else {
			for (int i = 0; i < n; i++) {
				set.add(in2[i]);
			}
			for (int i = 0; i < m; i++) {
				if (set.contains(in1[i])) {
					result[flag] = in1[i];
					flag++;
					set.remove(in1[i]);
				}
			}
		}
		return Arrays.copyOf(result, flag);
	}

	public static void main(String[] args) {
		int[] in1 = {5,6,7,8,10,20,10,10};
		int[] in2 = {2,6,9,10,15,10};
		System.out.println(findIntersection1(in1, in2));
		System.out.println(findIntersection2(in1, in2));
		System.out.println(findIntersection3(in1, in2));
		System.out.println(findIntersection4(in1, in2));
		System.out.println(Arrays.toString(intersection(in1, in2)));
	}
}
