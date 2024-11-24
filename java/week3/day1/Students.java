package week3.day1;
public class Students {
	public void getStudentInfo(int id) {
		System.out.println("The student id is: "+id);
	}
	public void getStudentInfo(int id, String name) {
		System.out.println("The student ID and Name is: "+id+" and "+name);
	}
	public void getStudentInfo(String email, long phoneNumber) {
		System.out.println("The email id and phone number is: "+email+" and "+phoneNumber);
	}
	public static void main(String[] args) {
		Students obj = new Students();
		obj.getStudentInfo(18);
		obj.getStudentInfo(18, "VK");
		obj.getStudentInfo("vk18@gmail.com", 1234567890l);
	}
}