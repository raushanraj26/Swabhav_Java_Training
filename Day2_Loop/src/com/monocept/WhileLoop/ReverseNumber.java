package com.monocept.WhileLoop;

import java.util.Scanner;

public class ReverseNumber {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner reversenumber=new Scanner(System.in);
        System.out.print("ENter Number:");
        int num=reversenumber.nextInt();
        int newnum=0;
        while(num>0) {
        	int d=num%10;
        	newnum=newnum*10+d;
        	num /=10;
        	

}
       	 
      System.out.print("the reversed number is:"+(newnum)); 	
       	 
        
        reversenumber.close();
	}

	}


