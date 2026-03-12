package com.monocept.ForLoop;

import java.util.Scanner;

public class PerfectNumber {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner perfectnumber = new Scanner(System.in);
		System.out.print("ENter Number:");
		int num = perfectnumber.nextInt();
		

		int sum=0;
		for (int i = 1; i < num; i++) {
			if(num%i==0) {
				sum+=i;
			}
		}
		if(sum==num) {
			System.out.print("");
		}
		
		perfectnumber.close();
	}
}
