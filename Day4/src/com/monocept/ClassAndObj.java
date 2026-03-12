package com.monocept;

class Student {

    String name;
    int age;

    Student() {
        System.out.println("Default Constructor");
    }

    Student(String n) {
        name = n;
    }

    Student(String n, int a) {
        name = n;
        age = a;
    }
}

public class ClassAndObj {
	 public static void main(String[] args) {
	        
	        Student s1 = new Student();
	        Student s2 = new Student("Raushan");
	        Student s3 = new Student("Raj", 23);
	        System.out.println(s1);
	        System.out.println(s2.name);

	    }

}
