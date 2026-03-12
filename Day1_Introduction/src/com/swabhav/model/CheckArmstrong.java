package com.swabhav.model;

import java.util.Scanner;

public class CheckArmstrong {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner checkarmstrong=new Scanner(System.in);
        System.out.print("Enter an 3-digit Integer");
        int num=checkarmstrong.nextInt();
        if(num>=100 && num<=999) {
        	int original=num;
        	int sum=0;
        	while(original>0) {
        		int digit=original%10;
        		sum += digit*digit*digit;
        		original /=10;
        	}
        	if(sum==num) {
        		System.out.println("Given number is Armstrong number");
        	}else {
        		System.out.println("Not a Armstrong number");
        	}
        	
        }else {
        	System.out.println("you not provided 3 digit number");
        }
        checkarmstrong.close();
	}

}
