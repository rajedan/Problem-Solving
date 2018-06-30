package psclass.basic.completesearch;

/**
 * Given an array of available coins and Sum S, Find an efficient algorithm
 * which returns minimum number of coins required to get S
 * 
 * @author rajesh
 * 
 */
public class MinCoinForSum {
	
	public static int getNCoins(int[] in, int s) {
		return auxGetNCoins(in, s, in.length - 1);
	}
	
	private static int auxGetNCoins(int[] in, int s, int end) {
		if (s == 0) return 0;
		if (end < 0) return Integer.MAX_VALUE;
		while (in[end] > s) end--;
		int first = auxGetNCoins(in, s-in[end], end) + 1;
		int second = auxGetNCoins(in, s, end-1);
		return min(first, second);
	}
	
	/**
	 * Find minimum out of first and second
	 * @param first
	 * @param second
	 * @return returns first if first is less then second, second otherwise
	 */
	private static int min(int first, int second) {
		return first < second ? first : second;
	}

	public static void main(String[] args) {
		int[] in1 = {1,3,4};
		System.out.println(getNCoins(in1, 6));
		int[] in2 = {1,2,3,5,10};
		System.out.println(getNCoins(in2, 22));
	}
}
