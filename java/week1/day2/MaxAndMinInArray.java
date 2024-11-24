package week1.day2;
import java.util.Arrays;
public class MaxAndMinInArray {
	public static void main(String[] args) {
		int[] num = {22, 3981, -19, 82, 0, 45, 3982, 37};
		Arrays.sort(num);
		/*
		 * for(int i=0; i<num.length; i++) { System.out.println(num[i]); }
		 */
		int minVal = num[0];
		int maxVal = num[num.length-1];
		System.out.println("The minimum value is: "+minVal);
		System.out.println("The maximum value is: "+maxVal);
	}
}