package com.monocept.WhileLoop;

import java.util.Scanner;

public class PrintNumber {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
         Scanner printnumber=new Scanner(System.in);
         System.out.print("ENter Number:");
         int num=printnumber.nextInt();
         int i=1;
         while(i<=num) {
        	 System.out.print(i);
        	 System.out.print(" ");
        	 i++;
        	 
         }
         printnumber.close();
	}


	
}
