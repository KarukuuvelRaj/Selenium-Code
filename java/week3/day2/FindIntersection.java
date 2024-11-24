package week3.day2;

import java.util.ArrayList;
import java.util.List;

public class FindIntersection {
	public static void main(String[] args) {
		int[] arr1={3,2,11,4,6,7,9};
		int[] arr2={1,2,8,4,6,7,8};
        List<Integer> obj = new ArrayList<Integer>();
        for (Integer val1 : arr1) {
			obj.add(val1);
		}
        List<Integer> obj1 = new ArrayList<Integer>();
        for (Integer val2 : arr2) {
			obj1.add(val2);
        }
        for (int i = 0; i < obj.size(); i++) {
			for (int j=0; j < obj1.size(); j++) {
					if(obj.get(i)==obj1.get(j)) {
						System.out.println(obj1.get(j));
					}
			}
		}
	}
}