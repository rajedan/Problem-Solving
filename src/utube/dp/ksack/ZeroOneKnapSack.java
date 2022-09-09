package utube.dp.ksack;

import java.util.Arrays;

public class ZeroOneKnapSack {


	public static void main(String[] args) {
		int[] wt = {1, 3, 4, 5};
		int[] val = {1, 4, 5, 7};
		int w = 7;

		int maxProfit = findMaxProfit(wt, val, w);
		System.out.println(maxProfit);

		maxProfit = findMaxProfitWithBottomUp(wt, val, w);
		System.out.println(maxProfit);
	}

	public static int findMaxProfit(int[] wt, int[] val, int w) {
		int[][] bucket = new int[wt.length + 1][w + 1];
		for (int[] ints : bucket) {
			Arrays.fill(ints, -1);
		}
		return findMaxProfitHelper(wt, val, w, wt.length, bucket);
	}

	private static int findMaxProfitHelper(int[] wt, int[] val, int w, int n, int[][] bucket) {
		if (n == 0 || w == 0) {
			return 0;
		}
		if (bucket[n][w] != -1) return bucket[n][w];

		int itemWt = wt[n - 1];
		int itemV = val[n - 1];
		if (itemWt > w)
			return bucket[n][w] = findMaxProfitHelper(wt, val, w, n - 1, bucket);

		return bucket[n][w] = Math.max((itemV + findMaxProfitHelper(wt, val, w - itemWt, n - 1, bucket)),
				findMaxProfitHelper(wt, val, w, n - 1, bucket));
	}

	public static int findMaxProfitWithBottomUp(int[] wt, int[] val, int w) {
		int n = wt.length;
		int[][] mem = new int[n+1][w+1];

		//initialization
		for (int i = 0; i < n+1; i++) {
			for (int j = 0; j < w+1; j++) {
				if(i==0 || j ==0)
					mem[i][j] = 0;
			}
		}

		//Bottom-Up process

		for (int i = 1; i < n+1; i++) {
			for (int j = 1; j < w+1; j++) {
				if (wt[i-1] > j) {
					//do not include
					mem[i][j] = mem[i-1][j];
				} else {
					mem[i][j] = Math.max(
							mem[i-1][j],
							val[i-1]+mem[i-1][j-wt[i-1]]
					);
				}
			}
		}
		for (int i = 0; i < mem.length; i++) {
			System.out.println(Arrays.toString(mem[i]));
		}
		return mem[n][w];
	}
}
