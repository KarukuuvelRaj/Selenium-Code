package week3.day2;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class MissingElementInAnArray {
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,7,6,8};
		List<Integer> obj = new ArrayList<Integer>();
		for (Integer var : arr) {
			obj.add(var);
		}
		Collections.sort(obj);
		//System.out.println(obj);
		for(int i =1; i<=obj.size(); i++) {
			if(i!=obj.get(i-1)) {
				System.out.println("The missing element in an array is: "+i);
				break;
			}
		}
	}
}