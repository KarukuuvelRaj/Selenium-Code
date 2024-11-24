package week3.day1;
public class Automation extends MultipleLangauge implements Language, TestTool {
	public static void main(String[] args) {
		Automation obj = new Automation();
		obj.Java();
		obj.Selenium();
		obj.python();
		obj.ruby();
	}
	@Override
	public void ruby() {
		System.out.println("This Abstract Ruby method is implemented in Automation class");
	}
	public void Selenium() {
		System.out.println("This method was designed in TestTool Interface and implemented in Automation class");
	}
	public void Java() {
		System.out.println("This method was designed in Language Interface and implemented in Automation class");
	}
}