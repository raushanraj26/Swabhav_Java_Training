package com.monocept.EcxeptionHandling;

import java.util.InputMismatchException;

public class MultipleCatchBlockEx {
	public static void main(String[] args) {
		// String s="abg";
//	System.out.print(s.charAt(0));
//	System.out.print(s.length());
		try {
			String[] s = { "hello", "world" };
			System.out.print(s[5]);
			String n=null;
			System.out.print(n.length());
			

		} catch (ArithmeticException e) {
			System.out.println("Exception Type: " + e.getClass().getSimpleName());

			System.out.println("Message: " + e.getMessage());

		} catch (NullPointerException e) {
			System.out.println("Exception Type: " + e.getClass().getSimpleName());

			System.out.println("Message: " + e.getMessage());

		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Exception Type: " + e.getClass().getSimpleName());

			System.out.println("Message: " + e.getMessage());

		} catch (InputMismatchException e) {
			System.out.println("Exception Type: " + e.getClass().getSimpleName());

			System.out.println("Message: " + e.getMessage());

		} catch (Exception e) {
			System.out.println("Exception Type: " + e.getClass().getSimpleName());

			System.out.println("Message: " + e.getMessage());

		}

	}
}
