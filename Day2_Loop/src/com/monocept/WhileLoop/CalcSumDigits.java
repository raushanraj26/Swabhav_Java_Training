package com.monocept.WhileLoop;

import java.util.Scanner;

public class CalcSumDigits {
	public static void main(String[] args) {
		Scanner calcsumdigits=new Scanner(System.in);
		System.out.println("Type Number:");
		int num=calcsumdigits.nextInt();
		int sum=0;
		while(num>0) {
			int d=num%10;
			sum+=d;
			num/=10;
			
		}
		System.out.println("The digit sum is:" +(sum));
		calcsumdigits.close();
	}

}
