package week1.day2;
import java.util.Arrays;
public class Anagram {
	public static void main(String[] args) {
		String one = "hello";
		String two = "eolhl";
		boolean isAnagram = true;
		char[] charArray1 = one.toCharArray();
		char[] charArray2 = two.toCharArray();
		Arrays.sort(charArray1);
		Arrays.sort(charArray2);
		/*
		 * if(charArray1.equals(charArray2)) { System.out.println("Anagram"); }else {
		 * System.out.println("Not an Anagram"); }
		 */
		for(int i = 0; i<charArray1.length; i++) {
			if(charArray1[i]!=charArray2[i]) {
				System.out.println("Not an Anagram");
				isAnagram = false;
				break;
			}
		}
		if(isAnagram == true) {
			System.out.println("Anagram");
		}
	}
}