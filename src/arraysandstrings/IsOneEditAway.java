package arraysandstrings;

public class IsOneEditAway {

	public static void main(String[] args) {
		boolean result = IsOneEditAway.isOneEditAway("Pal", "Pklo");
		System.out.println(result);

	}

	public static boolean isOneEditAway(String s1, String s2) {
		int[] arr = new int[256];
		int count = 0;
		s1 = s1.toLowerCase();
		s2 = s2.toLowerCase();
		if (s1.length() == s2.length() || Math.abs(s1.length() - s1.length()) == 1) {
			char[] arr1 = s1.toCharArray();
			for (int i = 0; i < arr1.length; i++) {
				int ascii = arr1[i];
				arr[ascii] = arr[ascii] + 1;
			}

			char[] arr2 = s2.toCharArray();
			for (int j = 0; j < arr2.length; j++) {
				int ascii = arr2[j];
				if (arr[ascii] == 0) {
					count++;
				} else
					continue;
			}
			if (count == 0 || count == 1)
				return true;
			return false;
		}
		return false;

	}

}
