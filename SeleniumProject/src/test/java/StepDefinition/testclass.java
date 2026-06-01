package StepDefinition;

import java.util.HashMap;
import java.util.Map;

public class testclass {


	public static void main(String[] args) {
		reverseString();
		System.out.println(isPalindrome("21"));
		System.out.println(countChars("ETHESH"));
		System.out.println(swapWords("Ethesh Gaur"));
	}
	
	public static void reverseString() {
		String s = "Ethesh Gaur";
		String rev= "";
		for(int i =s.length()-1; i>=0;i--) {
			rev +=s.charAt(i);
		}
		System.out.println(rev);
	}
	
	
	
	public static String isPalindrome(String s) {
	    for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
	        if (s.charAt(i) != s.charAt(j)) return "false";
	    }
	    return "true";
	}


	
	public static Map<Character, Integer> countChars(String s) {
	    Map<Character, Integer> map = new HashMap<>();

	    for (char c : s.toCharArray()) {
	        map.put(c, map.getOrDefault(c, 0) + 1);
	    }
	    return map;
	}
	
	public static String swapWords(String s) {
	    String[] words = s.split(" ");

	    // swap first and last
	    String temp = words[0];
	    words[0] = words[words.length - 1];
	    words[words.length - 1] = temp;

	    return String.join(" ", words);
	}




}
