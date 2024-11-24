package org.student;

import org.department.Department;

public class Student extends Department {
	String name = "Raj";
	int deptId = 10;
	int studId = 12;
public String studentName() {
	return name;
}
public int studentDept() {
	return deptId;
}
public int studentId() {
	return studId;
}
public static void main(String[] args) {
	Student obj = new Student();
	obj.collegeName();
	int collegeCode = obj.collegeCode();
	System.out.println(collegeCode);
	int collegeRank = obj.collegeRank();
	System.out.println(collegeRank);
	obj.deptName();
	String studentName = obj.studentName();
	System.out.println(studentName);
	int studentDept = obj.studentDept();
	System.out.println(studentDept);
	int studentId = obj.studentId();
	System.out.println(studentId);
}
}
