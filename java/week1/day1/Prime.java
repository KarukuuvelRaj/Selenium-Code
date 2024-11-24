package week1.day1;
public class Prime {
	public static void main(String[] args) {
		int n=7;
		boolean prime=true;
		for (int i=2;i<n;i++) {
			if(n%i==0) {
				System.out.println("Not a Prime");
				prime=false;
				break;
			}
		}if(prime==true) {
			System.out.println("Prime");
		}
	}
}
