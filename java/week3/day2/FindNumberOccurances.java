package week3.day2;

import java.util.Map;
import java.util.TreeMap;

public class FindNumberOccurances {

	public static void main(String[] args) {
		int[] inp = {2,3,-99,1,5,6,3,2,-1,4,2,1,6,-1,-99};
		Map<Integer, Integer> obj = new TreeMap<Integer, Integer>();
		for (int val : inp) {
			if(obj.containsKey(val)) {
				obj.put(val, obj.get(val)+1);
			}else {
				obj.put(val, 1);
			}
		}
		System.out.println(obj);
	}

}
