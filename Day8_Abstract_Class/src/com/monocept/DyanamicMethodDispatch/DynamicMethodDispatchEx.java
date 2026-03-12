package com.monocept.DyanamicMethodDispatch;

class Animal {
    void sound() {
        System.out.println("Animal makes sound");
    }
}
class Dog extends Animal {
    void sound() {
        System.out.println("Dog barks");
    }
}
public class DynamicMethodDispatchEx {
	 public static void main(String[] args) {

	        Animal obj = new Dog();   // Parent reference, Child object
	        obj.sound();              
	    }
}





