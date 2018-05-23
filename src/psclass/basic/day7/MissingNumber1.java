package psclass.basic.day7;

import java.util.Arrays;
import java.util.BitSet;

/**
 * Find missing number in an array containing 0,1...n as elements where n is size of array<br>
 * Note that missing number is in between 0 to n including 0 and n
 * @author rajesh
 *
 */
public class MissingNumber1 {
	
	/**
	 * Naive Approach/Brute Force
	 * Time  : O(n^2)
	 * Space : O(1)
	 * @param in
	 * @return
	 */
	private static int findMissingNumber1(int[] in) {
		int n = in.length;
		boolean isElemFound = Boolean.FALSE;
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j < n; j++) {
				if (i == in[j]) {
					isElemFound = Boolean.TRUE;
				}
			}
			if (!isElemFound) {
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * Time  : O(nlogn)
	 * Space : O(1)
	 * @param in
	 * @return
	 */
	private static int findMissingNumber2(int[] in) {
		Arrays.sort(in);
		for (int i = 1; i < in.length; i++) {
			if (in[i] - in[i-1] != 1) {
				return in[i]-1;
			}
		}
		return in.length;
	}
	
	private static int findMissingNumber3(int[] in) {
		BitSet set = new BitSet(in.length);
		for (int i = 0; i < in.length; i++) {
			set.set(in[i]);
		}
		for (int i = 0; i < set.size(); i++) {
			if (!set.get(i)) {
				return i;
			}
		}
		return -1;
	}
	
	private static int findMissingNumber4(int[] in) {
		return -1;
	}
	
	public static void main(String[] args) {
		
	}
}
