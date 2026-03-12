package com.monocept.WhileLoop;

import java.util.Scanner;

public class PrintOddNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner printoddnumber=new Scanner(System.in);
        System.out.print("ENter Number:");
        int num=printoddnumber.nextInt();
        int i=1;
        while(i<=num) {
if(i%2!=0) {
  	 System.out.print(i);
  	 System.out.print(" ");

}
       	 
       	 i++;
       	 
        }
        printoddnumber.close();

	}

}
