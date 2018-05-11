package lcode.contest.offer;

public class Temp {
	public static void main(String[] args) {
		String myStr = "[\"a\",\"b\",\"c\",\"\\n\"]";
		char data[] = myStr.toCharArray();
		
		System.out.println();
		for(char ch: data) {
			System.out.print(ch);
		}
		System.out.println();
		String str = new String(data);
		System.out.println(str);
	}
}
