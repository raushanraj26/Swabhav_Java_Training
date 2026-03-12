package com.monocept;


class Animal {
    void sound() {
        System.out.println("Animal makes sound");
    }
}

class Dog extends Animal {
    void bark() {
        System.out.println("Dog barks");
    }
}


public class TypeCasting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    System.out.println("----- Primitive Widening Casting -----");
        int intValue = 100;
        double doubleValue = intValue;   // Widening (automatic)
        System.out.println("Int value: " + intValue);
        System.out.println("Converted to double: " + doubleValue);


        System.out.println("\n----- Primitive Narrowing Casting -----");
        double num = 99.99;
        int narrowedValue = (int) num;   // Narrowing (manual)
        System.out.println("Double value: " + num);
        System.out.println("Converted to int: " + narrowedValue);


        System.out.println("\n----- Object Upcasting -----");
        Animal obj = new Dog();   // Upcasting (automatic)
        obj.sound();              // Parent method


        System.out.println("\n----- Object Downcasting -----");
        Dog d = (Dog) obj;        // Downcasting (manual)
        d.bark();  

	}

}
