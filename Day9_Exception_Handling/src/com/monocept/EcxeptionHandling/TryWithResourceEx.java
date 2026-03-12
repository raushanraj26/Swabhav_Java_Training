package com.monocept.EcxeptionHandling;
import java.util.Scanner;

public class TryWithResourceEx {
	 public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
		 System.out.println("Enter number:");
         int num = sc.nextInt();

         System.out.println("Number is: " + num);

//	        try(Scanner sc = new Scanner(System.in)) {
//
//	            System.out.println("Enter number:");
//	            int num = sc.nextInt();
//
//	            System.out.println("Number is: " + num);
//	        }
	    }
}
