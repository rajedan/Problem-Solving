package psclass.basic.day5And6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class AnagramGrouping {
	
	/**
	 * For given String of array, It groups the angrams and returns the list of
	 * angram groups <br>
	 * Here, group of anagram means List of Anagrams
	 * 
	 * Time  : O(n) where n is number of strings in String array Assumption : <br>
	 * Input Strings are in lower case. <br>
	 * String length are assumed to be constant(or very small). So, we are
	 * ignoring it for time complexity calculation
	 * 
	 * Space : O(n)
	 * @param str
	 * @return
	 */
	private static Collection<List<String>> getAnagramGroup(String[] str) {
		HashMap<String, List<String>> map = new HashMap<String, List<String>>();
		for (final String e : str) {
			char[] charArr = e.toCharArray();
			Arrays.sort(charArr);
			String key = new String(charArr);
			List<String> list = map.get(key);
			if (list == null) {
				map.put(key, new ArrayList<String>(){{
					add(e);
				}});
			} else {
				list.add(e);
			}
		}
		return map.values();
	}
	
	public static void main(String[] args) {
		String[] str = {"eat", "tea", "tan", "ate", "nat", "bat"};
		System.out.println(getAnagramGroup(str));
	}
}
