package psclass.basic.day4;

import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Random;

/**
 * Given an array of integers, Check if there exist two numbers such that they
 * add up to a specific target.
 * 
 * You may assume that each input would have exactly one solution, and you may
 * not use the same element twice.
 * 
 * Example:
 * 
 * Input : nums = [2, 7, 11, 15], target = 9, Output : True
 * 
 * @author rajesh
 * 
 */
public class TwoSumExistance {

	private static final boolean LOG_FLAG = Boolean.FALSE;

	/**
	 * Checks whether, there exist two elements in the array whose sum is equals
	 * to target Time : O(n^2) Space : O(1)
	 * 
	 * @param in
	 * @param target
	 * @return true if desired elements exist, false otherwise
	 */
	private static boolean twoSum1(int[] in, int target) {
		final Date start = new Date();
		for (int i = 0; i < in.length; i++) {
			for (int j = i + 1; j < in.length; j++) {
				if (target - in[i] == in[j]) {
					logPerformace(start, new Date(), "twoSum1");
					return true;
				}
			}
		}
		logPerformace(start, new Date(), "twoSum1");
		return false;
	}

	/**
	 * Approach : Sort the array and use binary search to search the element
	 * Time : O(nlogn) Space : O(1)
	 * 
	 * Time <= nlogn(sorting) + nlogn(searching element)
	 * 
	 * @param in
	 * @param target
	 * @return
	 */
	private static boolean twoSum21(int[] in, int target) {
		final Date start = new Date();
		Arrays.sort(in);
		final int size = in.length;
		for (int i = 0; i < size - 1; i++) {
			if (Arrays.binarySearch(in, i + 1, size - 1, (target - in[i])) > 0) {
				logPerformace(start, new Date(), "twoSum21");
				return true;
			}
		}
		logPerformace(start, new Date(), "twoSum21");
		return false;
	}

	/**
	 * Approach : Sort array and search element by traversing from start and end
	 * index in a single iteration in sorted array Time : O(nlogn) Space : O(1)
	 * 
	 * Time <= nlogn(Sorting) + n(finding element)
	 * 
	 * @param in
	 * @param target
	 * @return
	 */
	private static boolean twoSum22(int[] in, int target) {
		final Date startDate = new Date();
		Arrays.sort(in);
		int start = 0, end = in.length - 1;
		while (start < end) {
			if (in[start] + in[end] == target) {
				logPerformace(startDate, new Date(), "twoSum22");
				return true;
			}
			if (in[start] + in[end] > target) {
				end--;
			} else {
				start++;
			}
		}
		logPerformace(startDate, new Date(), "twoSum22");
		return false;
	}

	/**
	 * Approach : Take a set to store the previous traversed elements. Lookup
	 * for (target-current) in set, if exist then we have found the pair, false
	 * otherwise Time : O(n) Space : O(n)
	 * 
	 * Note : Time complexity can be O(n^2) in worst case such as : we assume
	 * that hashset lookup takes some constant time, but in worst case it will
	 * be O(n) and hence overall Time will be O(n^2) times will make it
	 * 
	 * @param in
	 * @param target
	 * @return
	 */
	private static boolean twoSum3(int[] in, int target) {
		final Date start = new Date();
		HashSet<Integer> set = new HashSet<Integer>();
		int temp = 0;
		for (int i = 0; i < in.length; i++) {
			temp = in[i];
			if (set.contains(target - temp)) {
				logPerformace(start, new Date(), "twoSum3");
				return true;
			} else {
				set.add(temp);
			}
		}
		logPerformace(start, new Date(), "twoSum3");
		return false;
	}

	public static void main(String[] args) {
		int size = 1000000;
		int[] in = new int[size];
		Random rand = new Random();
		for (int i = 0; i < size; i++) {
			in[i] = rand.nextInt(20);
		}
		if (LOG_FLAG) {
			System.out.println(Arrays.toString(in));
		}
		System.out.println(twoSum1(in, 10));
		System.out.println(twoSum21(in, 10));
		System.out.println(twoSum22(in, 10));
		System.out.println(twoSum3(in, 10));
	}

	private static void logPerformace(Date start, Date end, String msg) {
		System.out.println("\t" + msg + " performance : "
				+ (end.getTime() - start.getTime()) / 1000.0 + " Seconds");
	}
}
