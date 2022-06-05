package arraysandstrings;

public class CheckForPemutation {

	public static void main(String[] args) {
		boolean result = CheckForPemutation.checkForPermutation("cdbfg", "cbdfg");
		System.out.println(result);
	}

	public static boolean checkForPermutation(String s1, String s2) {
		if(s1.length() != s2.length())
			return false;
		
		int[] arr = new int[256];
		char[] chararr1 = s1.toCharArray();
		for (int i = 0; i < chararr1.length; i++) {
			int ascii = chararr1[i];
			arr[ascii] = arr[ascii] + 1;
		}
		char[] chararr2 = s2.toCharArray();
		for (int j = 0; j < chararr2.length; j++) {
			int ascii = chararr2[j];
			if (arr[ascii] == 0) {
				return false;
			} else
				arr[ascii] = arr[ascii] - 1;

		}

		return true;
	}

}
