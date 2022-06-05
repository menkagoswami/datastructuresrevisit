package arraysandstrings;

import java.util.Arrays;

public class CheckForUniqueString {

	public static void main(String[] args) {
		boolean result = CheckForUniqueString.checkForUniqueString("abcd");
		System.out.println(result);
		boolean res = CheckForUniqueString.checkForUniqueChar("abcdeme");
		System.out.println(res);
	}

	// without using additional data structure
	public static boolean checkForUniqueString(String str) {
		char[] charr = str.toCharArray();
		Arrays.sort(charr);
		for (int i = 0; i < charr.length - 1; i++) {
			if (charr[i] == charr[i + 1]) {
				return false;
			} else
				continue;
		}
		return true;
	}
	// using additional data structure
	public static boolean checkForUniqueChar(String str) {
		int[] arr = new int[256];
		for (int i = 0; i < str.length(); i++) {
			int ascii = str.charAt(i);
			if (arr[ascii] == 1)
				return false;
			arr[ascii] = 1;
		}
		return true;
	}

}
