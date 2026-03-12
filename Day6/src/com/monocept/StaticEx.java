package com.monocept;

class Student {

    String name;                     // Non-static variable
    static String school = "ABC School";  // Static variable

    // Non-static method
    void display() {
        System.out.println(name + " studies in " + school);
    }

    // Static method
    static void changeSchool(String newSchool) {
        school = newSchool;
    }
}


public class StaticEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

        Student s1 = new Student();
        s1.name = "Raushan";

        Student s2 = new Student();
        s2.name = "Aman";

        s1.display();
        s2.display();

        // Calling static method
        Student.changeSchool("XYZ School");

        System.out.println("After changing school:");

        s1.display();
        s2.display();


	}

}
