package utube.dp.ksack;

import java.util.ArrayList;
import java.util.Arrays;

public class SubsetSum {

	public static boolean isSubsetSumPossible(int[] nums, int sum) {
		return isSubsetSumPossibleHelper(nums, sum, nums.length);
	}

	private static boolean isSubsetSumPossibleHelper(int[] nums, int sum, int n) {
		if (sum == 0) return true;
		if (n == 0) return false;
		if (sum < nums[n - 1]) return isSubsetSumPossibleHelper(nums, sum, n - 1);
		return (isSubsetSumPossibleHelper(nums, sum - nums[n - 1], n - 1) || isSubsetSumPossibleHelper(nums, sum, n - 1));
	}

	public static boolean isSubsetSumPossibleOptimized(int[] nums, int sum) {
		if (sum == 0) return true;
		int n = nums.length;
		boolean[][] mem = new boolean[n + 1][sum + 1];

		for (int i = 0; i < n + 1; i++) {
			for (int j = 0; j < sum + 1; j++) {
				if (j == 0) mem[i][j] = true;
				else mem[i][j] = false;
			}
		}
		/*for (boolean[] bool : mem) {
			System.out.println(Arrays.toString(bool));
		}*/
		System.out.println("------------------------------");

		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < sum + 1; j++) {
				if (j >= nums[i - 1]) {
					mem[i][j] = (mem[i - 1][(j - nums[i - 1])] || mem[i - 1][j]);
				} else mem[i][j] = mem[i - 1][j];
			}
		}

		/*for (boolean[] bool : mem) {
			System.out.println(Arrays.toString(bool));
		}*/
		if (mem[n][sum]) {
			printSubset(mem, n, sum, nums);
		}
		return mem[n][sum];
	}

	private static void printSubset(boolean[][] mem, int n, int sum, int[] nums) {
		int currSum = sum;
		ArrayList<Integer> subset = new ArrayList<Integer>();
		while (currSum != 0) {
			for (int i = 0; i <= n; i++) {
				if (mem[i][currSum]) {
					subset.add(nums[i-1]);
					currSum = currSum-nums[i-1];
					break;
				}
			}
		}
		System.out.println(subset);
	}

	public static void main(String[] args) {
		int[] nums = {2, 3, 7, 8, 10};
		int sum = 17;
		//System.out.println(isSubsetSumPossible(nums, sum));
		System.out.println(isSubsetSumPossibleOptimized(nums, sum));
	}
}
