package com.monocept.EcxeptionHandling;

public class ExceptionEx {
	public static void main(String[] args) {

        try {
            int result = 10 / 0;
        } catch (Exception e) {
            System.out.println(e);
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Finally block executed");
        }
    }

}
