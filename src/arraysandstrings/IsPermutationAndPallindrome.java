package arraysandstrings;

import java.util.Arrays;

public class IsPermutationAndPallindrome {

	public static void main(String[] args) {
		boolean result = IsPermutationAndPallindrome.isPermutation("Tatc coa");
		System.out.println(result);
	}

	public static boolean isPermutation(String original) {
		String str = original.replace(" ", "").toLowerCase();

		int[] arr = new int[256];
		int count = 0;
		char[] originalArr = str.toCharArray();
		for (int i = 0; i < originalArr.length; i++) {
			int ascii = originalArr[i];
			arr[ascii] = arr[ascii] + 1;
		}

		System.out.println(Arrays.toString(arr));

		for (int j = 0; j < arr.length; j++) {
			if (arr[j] > 0) {
				if (arr[j] % 2 == 0) {
					continue;
				} else {
					count++;
				}
			} else
				continue;
		}
		if (count == 0 || count == 1)
			return true;
		return false;
	}

}
