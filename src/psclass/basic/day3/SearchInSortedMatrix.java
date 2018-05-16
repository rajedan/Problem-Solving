package psclass.basic.day3;

/**
 * Write an efficient algorithm that searches for a value in an m x n matrix.
 * This matrix has the following properties:
 * 
 * Integers in each row are sorted from left to right. The first integer of each
 * row is greater than the last integer of the previous row. 
 * Input: 
 * matrix = [
 * 		[1,  3,  5,  7], 
 * 		[10, 11, 16, 20], 
 * 		[23, 30, 34, 50] 
 * ] 
 * target = 3 
 * 
 * Output: true
 * 
 * @author rajesh
 * 
 */
public class SearchInSortedMatrix {
	
	/**
	 * Checks whether target is present in provided 2D array in <br>
	 * Time Complexity : O(log(m*n)) Space Complexity : O(1) <br>
	 * Approach : Flatten the 2D array and Consider it as single sorted array,
	 * now apply Divide and Prune(Binary Search on it to find the target)
	 * 
	 * @return
	 */
	private static boolean isElementPresent(int[][] in, int target) {
		if (in == null || in.length == 0) {
			return false;
		}
		int m = in.length, n = in[0].length;
		int l = 0, r = m * n - 1;
		while (l <= r) {
			int mid = (l + r) / 2;
			int temp = in[mid / n][mid % n];
			if (target == temp) {
				return true;
			}
			if (target > temp) {
				l = mid + 1;
			}
			if (target < temp) {
				r = mid - 1;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		int[][] in = {{1,11}};//{{1,3,5,7},{10,11,16,20},{23,30,34,50}};
		System.out.println(isElementPresent(in, 11));
	}
}
