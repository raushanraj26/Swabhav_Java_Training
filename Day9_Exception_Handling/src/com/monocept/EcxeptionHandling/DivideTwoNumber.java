6package com.monocept.EcxeptionHandling;

import java.util.Scanner;

public class DivideTwoNumber {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		try {
			System.out.print("Enter first number: ");
			int a=sc.nextInt();
			System.out.print("Enter secondnumber: ");
			int b=sc.nextInt();
			int res=a/b;
			System.out.println("Result is : " + res);
		}catch(Exception e) {
			
			 System.out.println("Exception Type: " + 
				        e.getClass().getSimpleName());

				    System.out.println("Message: " + e.getMessage());
			
			//System.out.print(e);
//			System.out.println(e.getMessage());
			//  System.out.println(e.getClass());
			
			//System.out.println(e.toString());
			//e.printStackTrace();
			
			
		}finally {
			System.out.print("Program Ended! ");
		}
		
	}

}
