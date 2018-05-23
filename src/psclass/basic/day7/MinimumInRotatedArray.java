package psclass.basic.day7;

/**
 * Finding minimum in a rotated array<br>
 * Assume no duplicate exists in the array<br>
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/
 * @author rajesh
 *
 */
public class MinimumInRotatedArray {
	
	/**
	 * Naive Approach/Brute Force
	 * Time  : O(n)
	 * Space : O(1)
	 * @param in
	 * @return
	 */
	private static int findMinimum1(int[] in) {
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < in.length; i++) {
			if (in[i] < min) {
				min = in[i];
			}
		}
		return min;
	}
	
	/**
	 * Based on Binary Search
	 * Time  : O(logn)
	 * Space : O(1)
	 * @param in
	 * @return
	 */
	private static int findMinimum2(int[] in) {
		if (in == null || in.length == 0)
			return 0;
		int n = in.length - 1;
		if (in[0] < in[n])
			return in[0];
		int l = 0, r = n, mid = 0;
		while (l < r) {
			mid = l - (l - r) / 2;
			if (in[mid] < in[r]) {
				r = mid;
			} else {
				l = mid + 1;
			}
		}
		return in[l];
	}

	public static void main(String[] args) {
		int[] in = {12,13,14,2,3,4,5,6,10,11};
		System.out.println(findMinimum1(in));
		System.out.println(findMinimum1(in));
	}
}
