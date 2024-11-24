package week1.day2;
public class ReverseTheString {
	public static void main(String[] args) {
		String inp = "TestLeaf";
		char[] charArray = inp.toCharArray();
		for (int i=charArray.length-1;i>=0;i--) {
			System.out.print(charArray[i]);
		}
	}
}