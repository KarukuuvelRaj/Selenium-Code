package week3.day2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortingUsingCollection {

	public static void main(String[] args) {
		String[] input = {"HCL","Wipro","Aspire Systems","CTS"};
		List<String> obj = new ArrayList<String>();
		for (String str : input) {
			obj.add(str);
		}
		System.out.println(obj);
		Collections.sort(obj);
		Collections.reverse(obj);
		System.out.println("After reversing the strings: "+obj);
	}

}
