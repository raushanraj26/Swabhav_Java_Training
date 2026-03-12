package com.monocept;

//Class
class Student {
	private String name;

	// Getter
	public String getName() {
		return name;
	}

	// Setter
	public void setName(String name) {
		this.name = name;
	}
}

public class GetterAndSetterEx {

	public static void main(String[] args) {
		
		Student s1 = new Student();

		s1.setName("Raushan"); // setting value
		System.out.println(s1.getName()); // getting value
	}

}
