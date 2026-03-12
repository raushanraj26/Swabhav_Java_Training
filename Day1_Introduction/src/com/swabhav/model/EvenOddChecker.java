package com.swabhav.model;

import java.util.Scanner;

public class EvenOddChecker {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner evenoddchecker=new Scanner(System.in);
        System.out.print("Enter an Integer");
        int num=evenoddchecker.nextInt();
        if(num%2==0) {
       	 System.out.println("Given number is even");
        }else {
       	 System.out.println("Given number is Odd");
        }
        evenoddchecker.close();
	}

}
