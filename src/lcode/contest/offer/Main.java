/**
 * This class is to implement the serializer and deserializer for char array. Description of the problem is as below:
 * 
 * Please implement the serializer and deserializer for char array below.
 * For char arrays, we follow the JSON standard according to http://www.json.org/
 * Therefore, a single character A is represented as "A" (wrapped in double quotes instead of single quotes).
 * A char array containing 3 elements "A", "B", "C" is represented in string as ["A","B","C"].
 * For the purpose of this problem, you must not use JSON parser library or eval method.
 * Standard library provided by the language (not including JSON library) is allowed.
 * 
 */
package lcode.contest.offer;

//Please implement the serializer and deserializer for char array below.
//For char arrays, we follow the JSON standard according to http://www.json.org/
//Therefore, a single character A is represented as "A" (wrapped in double quotes instead of single quotes).
//A char array containing 3 elements "A", "B", "C" is represented in string as ["A","B","C"].
//For the purpose of this problem, you must not use JSON parser library or eval method. 
//Standard library provided by the language (not including JSON library) is allowed.

class Main {
	public static String charArrayToString(char[] param) throws Exception {
		StringBuffer result = new StringBuffer("[");
		for(char c: param) {
			System.out.print(c);
			result.append("\""+c+"\",");
		}
		
		result = result.length()<2?result:new StringBuffer(result.substring(0, result.length()-1));
		result.append("]");
		System.out.println("yeah, result is:"+result);
		return result.toString();
	}

	// Bonus point if your deserializer is able to deal with whitespaces between
	// elements.
	// For example: param = "[  \"a\",  \"b\", \"c\"  ]"
	public static char[] stringToCharArray(String param) throws Exception {
		//System.out.println("realStr: "+param);
		//System.out.println("after replacing space: "+param.replaceAll("\\s+",""));
		String realParam = param.replaceAll("\\s+","");//without space param
		realParam = realParam.replaceAll("\"", "").replaceAll(",", "");
		String resultStr = (realParam.length()<=2?"":realParam.substring(1, realParam.length()-1));
		
		//System.out.println("after replacing quotes: "+resultStr);
		return resultStr.toCharArray();
	}

	public static char[] anotherStringToCharArray(String param) {
		char[] resultArray = null;
		//param = param.repla
		return resultArray;
	}
	
	public static void main(String[] args) {
     String[] testcases = {
         "[]",
         "[\"a\",\"b\",\"c\"]",
         "[\"T\",\"e\",\"!\",\"'\"]",
         "[\"'\",\"\\\"\",\"c\"]",
         "[\"\\n\",\"\\t\",\"'\",\"\\\"\",\"\\\\\"]"
     };

     for(String testcase : testcases) {
         try {
        	 char[] chArr = stringToCharArray(testcase);
        	 System.out.println("test-case**********input is::"+testcase);
        	 System.out.println("str2charArray:"+charArrayToString(chArr));
             if (!charArrayToString(stringToCharArray(testcase)).equals(testcase)) {
                 System.out.println("TESTCASE FAILED : {}" + testcase);
             } else {
                 System.out.println("TESTCASE PASSED");
             }
             System.out.println();
         } catch(Exception e) {
             System.out.println("Exception occured in testcase : " + testcase);
             break;
         }
     }
 }
}
