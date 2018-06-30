package psclass.basic.dp;

public class LIS {
	
	public static void test(int[] in) {
		for (int i = 0; i < in.length; i++) {
			for (int j = i+1; j < in.length; j++) {
				for (int j2 = 0; j2 <= i; j2++) {
					System.out.print(in[j2]+",");
				}
				System.out.println(in[j]+"");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		int[] in = {10,5,8,15,11};
		test(in);
	}
}