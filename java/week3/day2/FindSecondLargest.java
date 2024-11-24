package week3.day2;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class FindSecondLargest {
	public static void main(String[] args) {
		int[] data = {3,2,11,4,6,7,8,16};
		List<Integer> obj = new ArrayList<Integer>();
		for (Integer var : data) {
			obj.add(var);
		}
		Collections.sort(obj);
		System.out.println("The second largest number is: "+obj.get(obj.size()-2));
	}
}