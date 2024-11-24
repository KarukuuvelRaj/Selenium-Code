package week3.day1;

public class Bus extends Vehicle{
public boolean isSchoolBus() {
	return true;
}
public void noOfSeats(int a) {
	System.out.println("Number of seats: "+a);
}
public void noOfSeats(int a, int b) {
	System.out.println("Number of seats: "+a);
	System.out.println("Number of seats: "+b);
}
}
