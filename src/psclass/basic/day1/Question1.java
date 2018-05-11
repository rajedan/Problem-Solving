package psclass.basic.day1;

import java.util.Arrays;

/**
 * Question1 : Find the duplicate number in an integer array of size n whose elements are 1 to n-1
 * Note that there can be more then 1 duplicate element and you can find any one of them
 * 
 * @author rajesh
 *
 */

public class Question1 {
	
	/**
	 * Naive approach
	 * @param array
	 * @return
	 */
	private static int findDuplicateIdeaOne(int[] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = i+1; j < array.length; j++) {
				if (array[i] == array[j]) {
					return array[i];
				}
			}
		}
		System.out.println("Not Found");
		return -1;
	}
	
	private static int findDuplicateIdeaTwo(int[] array) {
		Arrays.sort(array);
		for (int i = 0; i < (array.length-1); i++) {
			if (array[i]==array[i+1]) {
				return array[i];
			}
		}
		System.out.println("Not Found");
		return -1;
	}
	
	private static int findDuplicateIdeaThree(int[] array) {
		return -1;
	}
	
	private static int findDuplicateIdeaFour(int[] array) {
		int index = 0;
		for (int i = 0; i < array.length; i++) {
			index = Math.abs(array[i]);
			if (array[index] < 0) {
				return Math.abs(array[index]);
			} else {
				array[index] = -array[index];
			}
		}
		System.out.println("Not Found");
		return -1;
	}
	
	public static void main(String[] args) {
		int[] array = {1,4,2,3,4};
		System.out.println(findDuplicateIdeaOne(array));
		System.out.println(findDuplicateIdeaTwo(array));
		System.out.println(findDuplicateIdeaFour(array));
	}
}