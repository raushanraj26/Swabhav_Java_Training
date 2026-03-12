package com.monocept.EcxeptionHandling;

public class ThrowableEx {
    public static void main(String[] args) {

        try {
            int number = 10 / 0;   // ArithmeticException
        } catch (Throwable t) {

            System.out.println("Exception caught using Throwable");
            System.out.println("Message: " + t.getMessage());
            System.out.println("Class: " + t.getClass().getName());
        }

        System.out.println("Program continues normally...");
    }
}


