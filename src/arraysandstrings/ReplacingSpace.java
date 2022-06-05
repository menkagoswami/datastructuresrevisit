package arraysandstrings;

public class ReplacingSpace {

	public static void main(String[] args) {
		ReplacingSpace.replacingSpace("Mr John Smith is developer   ",26 );
	}
	
	public static void replacingSpace(String s1, int length) {
		if(s1.length() == 0)
			return;
		char[] chararr1 = s1.toCharArray();
		int spacecount=0;
		for (int i = 0; i < chararr1.length; i++) {
			if(chararr1[i] != ' ') {
				spacecount++;
			}else
				continue;
		}
		char[] ch = s1.trim().toCharArray();
		int totallength = length + spacecount*3;
		StringBuffer str = new StringBuffer(totallength);
		
		for (int i = 0; i < ch.length; i++) {
			if(ch[i] != ' ') {
				str.append(ch[i]);
			}else
				str.append("%20");
		}
		System.out.println(str.toString());
	}

}
