package com.monocept;

class Student {
    String name;
    int marks;

    Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    void display() {
        System.out.println(name + " " + marks);
    }
}
public class ArrayOfObjEx {
	 public static void main(String[] args) {

	        // Step 1: Declare array
	        Student[] students = new Student[3];

	        // Step 2: Create objects
	        students[0] = new Student("Raushan", 90);
	        students[1] = new Student("Abc", 85);
	        students[2] = new Student("def", 95);

	        // Step 3: Access objects
	        for(int i = 0; i < students.length; i++) {
	            students[i].display();
	        }
	    }

}
