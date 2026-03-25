package com.monocept.StudentPerformanceTracker.model;

public class Student {
	private String stuId;
	private String name;
	private String dept;
	public Student(String stuId,String name,String dept) {
		this.stuId=stuId;
		this.name=name;
		this.dept=dept;
	}
	public String getid() {
		return stuId;
	}
	public String getname() {
		return name;
	}
	public String dept() {
		return dept;
	}

	
}
