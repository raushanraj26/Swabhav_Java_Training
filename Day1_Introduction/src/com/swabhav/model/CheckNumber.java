package com.swabhav.model;
import java.util.Scanner;
public class CheckNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         Scanner checknumber=new Scanner(System.in);
         System.out.print("Enter an Integer");
         int num=checknumber.nextInt();
         if(num>0) {
        	 System.out.println("Given number is positive");
         }else if(num<0) {
        	 System.out.println("Given number is Negative");
        	 
         }else {
        	 System.out.println("Given number is Zero");
         }
         checknumber.close();
	}

}
