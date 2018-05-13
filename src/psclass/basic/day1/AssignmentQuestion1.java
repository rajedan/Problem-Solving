package psclass.basic.day1;

/**
 * Given an array of integers, return indices of the two numbers such that they
 * add up to a specific target. You may assume that each input would have
 * exactly one solution, and you may not use the same element twice.
 * 
 * [2, 7, 11, 15], target = 9, return [0, 1]. 
 * Because nums[0] + nums[1] = 2 + 7 = 9
 * 
 * @author rajesh
 * 
 */
public class AssignmentQuestion1 {

	/**
	 * Naive Approach
	 * Time Complexity : O(n^2)
	 * @param array
	 * @param target
	 * @return
	 */
	private static int[] findPairOne(int[] array, int target) {
		int[] result = { -1, -1 };
		int lookup = 0;
		for (int i = 0; i < array.length; i++) {
			lookup = target - array[i];
			for (int j = i+1; j < array.length; j++) {
				if (array[j] == lookup) {
					result[0] = i;
					result[1] = j;
					return result;
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int[] array = { 2, 7, 11, 15 };
		show(findPairOne(array, 9));
	}
	
	/**
	 * Prints the int array
	 * @param array
	 */
	private static void show(int[] array) {
		System.out.print("[");
		for(int e : array) {
			System.out.print(e+",");
		}
		System.out.println("]");
	}
}
