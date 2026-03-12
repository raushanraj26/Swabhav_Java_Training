//A Wrapper Class is a class that wraps (converts) primitive data types into objects.
//Java is object-oriented, but primitive types are not objects.
//So Java provides wrapper classes to use primitives as objects.

package com.monocept;
import java.util.*;

public class WrapperClassEx {
	
	public static void main(String[] args) {

        // Autoboxing
        int a = 5;
        Integer objA = a;

        // Unboxing
        Integer objB = 10;
        int b = objB;

        System.out.println("Autoboxed: " + objA);
        System.out.println("Unboxed: " + b);

        // Using in Collection
        ArrayList<Integer> list = new ArrayList<>();
        list.add(100);  // Autoboxing
        list.add(200);

        System.out.println("ArrayList: " + list);

        // Wrapper utility method
        String str = "123";
        int number = Integer.parseInt(str);

        System.out.println("Converted string to int: " + number);
    }

}
