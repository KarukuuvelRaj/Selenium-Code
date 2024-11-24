package week3.day1;

public class Desktop extends Computer{
	public String desktopSize() {
		return "36inch";
	}
	public static void main(String[] args) {
		Desktop obj1=new Desktop();
		String computerModel = obj1.computerModel();
		System.out.println(computerModel);
		String desktopSize = obj1.desktopSize();
		System.out.println(desktopSize);
	}
}