package week3.day1;

public class MyTravel {
public static void main(String[] args) {
	AshokLeyland obj = new AshokLeyland();
	obj.applyBrake();
	obj.doHorn();
	obj.workAgri();
	obj.isLorryAvailable();
	Tata obj1=new Tata();
	obj1.applyBrake();
	obj1.doHorn();
	obj1.noOfSeats(45);
	obj1.noOfSeats(45, 2);
	boolean schoolBus = obj1.isSchoolBus();
	System.out.println(schoolBus);
	String prodName = obj1.prodName();
	System.out.println(prodName);
}
}
