package week1.day2;
public class OddIndexToUpperCase {
	public static void main(String[] args) {
		String test = "changeme";
		char[] charArray = test.toCharArray();
		for (int i=0;i<charArray.length;i++) {
			if(i%2==0) {
				System.out.println(charArray[i]);
				
			}
		}
	}
}