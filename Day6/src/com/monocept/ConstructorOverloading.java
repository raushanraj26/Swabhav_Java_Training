package com.monocept;


class Student {

    String name;
    int age;

    Student() {
        name = "Unknown";
        age = 0;
    }

    Student(String name) {
        this.name = name;
    }

    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void display() {
        System.out.println(name + " " + age);
    }
}


public class ConstructorOverloading {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Student s1 = new Student();
	        Student s2 = new Student("Raushan");
	        Student s3 = new Student("Aman", 21);

	        s1.display();
	        s2.display();
	        s3.display();

	}

}
