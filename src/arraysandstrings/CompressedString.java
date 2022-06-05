package arraysandstrings;

public class CompressedString {

	public static void main(String[] args) {
		String res = CompressedString.compressedString("aaabbccccdddm");
		System.out.println(res);
	}

	public static String compressedString(String s1) {
		char[] arr = s1.toCharArray();
		int count = 1;
		StringBuffer sb = new StringBuffer("");
		int i;
		for (i = 0; i < arr.length - 1; i++) {
			if (arr[i] == arr[i + 1]) {
				++count;
			} else {
				sb.append(arr[i]).append(count);
				count = 1;
			}
		}
		String result = sb.append(arr[i]).append(count).toString();
		if(result.length() < s1.length())
			return result;
		return s1;
	}

}
