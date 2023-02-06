package com.model;

public class Student {
	private String department;
	private String studentId;
	private String name;
	private int marks;
	private String pass;
	
	public Student(String department, String studentId, String name, int marks) {
		this.department = department;
		this.studentId = studentId;
		this.name = name;
		this.marks = marks;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
	
}
