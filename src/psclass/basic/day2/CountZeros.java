package psclass.basic.day2;

/**
 * 
 * Given an array that consists of zeros followed by ones'. Find an efficient
 * algorithm to count the number of zeros <br>
 * example : Input : [0,0,0,0,0,1,1,1] <br>
 * Output : 5
 * 
 * @author rajesh
 * 
 */
public class CountZeros {

	/**
	 * Counts the number of zeros in array and return the count
	 * 
	 * @param array
	 * @return
	 */
	private static int getCountOfZeros(int[] array) {
		int l = 0, r = array.length;
		while ((r - l) > 1) {
			// int m = (l + r) / 2; //Chance of getting Integer OverFlowError in
			// this addition arithmatic, Hence
			// writing below snippet to avoid it
			int m = l + (r - l) / 2;
			if (array[m] == 0) {
				l = m;
			} else {
				r = m - 1;
			}
		}
		if (array[r] == 0)
			return (r + 1);
		if (array[l] == 0)
			return (l + 1);
		return 0;
	}

	public static void main(String[] args) {
		int[] array = new int[] { 0, 0, 0, 0, 0, 0, 0, 1, 1, 1 };
		System.out.println(getCountOfZeros(array));
	}
}
