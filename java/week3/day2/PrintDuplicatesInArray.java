package week3.day2;
import java.util.Set;
import java.util.TreeSet;
public class PrintDuplicatesInArray {
	public static void main(String[] args) {
		int[] arr = {14,12,13,11,15,20,14,18,16,17,19,18,17,20};
		Set<Integer> obj = new TreeSet<Integer>();
		for (Integer val : arr) {
			if(obj.add(val)== false) {
				System.out.println(val +" is duplicated");
			}
		}
	}
}