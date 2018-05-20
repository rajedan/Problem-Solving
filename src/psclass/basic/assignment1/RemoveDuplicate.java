package psclass.basic.assignment1;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/
 * 
 * @author rajesh
 *
 */

public class RemoveDuplicate {
	
	/**
	 * Time  : O(n)
	 * Space : O(1)
	 * @param in
	 * @return
	 */
	public static int removeDuplicates(int[] in) {
		 if (in == null || in.length == 0) {
	            return 0;
	    }
		int prev = in[0];
		int index = 1;
		for (int i = 1; i < in.length; i++) {
			if (in[i]!= prev) {
				in[index] = in[i];
				index ++;
				prev = in[i];
			}
		}
		return index;
	}

	public static void main(String[] args) {
		int[] in = {};
		int len = removeDuplicates(in);
		System.out.println(Arrays.toString(in));
		for (int i = 0; i < len; i++) {
			System.out.print(in[i]);
		}
	}
}
