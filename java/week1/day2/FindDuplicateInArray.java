package week1.day2;

import java.util.Arrays;

public class FindDuplicateInArray {
	public static void main(String[] args) {
		int[] val= {12,67,34,12,89,69,67,69,34};
		int count=0;
		Arrays.sort(val);
		for(int i=0;i<val.length-1;i++) {
			if(val[i]==val[i+1]) {
				count++;
			}
		}
		System.out.println("Number of duplicates: "+count);
	}
}