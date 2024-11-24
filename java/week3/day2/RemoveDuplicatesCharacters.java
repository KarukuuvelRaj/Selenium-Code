package week3.day2;

import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveDuplicatesCharacters {
	public static void main(String[] args) {
		String input = "PayPal India";
		char[] values = input.toCharArray();
		Set<Character> obj = new LinkedHashSet<Character>();
		for (Character str : values) {
			if(str!=' ') {
				obj.add(str);	
			}
		}
		System.out.println(obj);
	}
}