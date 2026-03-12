package com.monocept.WhileLoop;

import java.util.Scanner;

public class PalindromeChecker {
	public static void main(String[] args) {
		Scanner palindromechecker=new Scanner(System.in);
		System.out.print("Give Number:");
		int num=palindromechecker.nextInt();
		int temp=num;
		int newnum=0;
		while(temp>0) {
			int d=temp%10;
			newnum=newnum*10+d;
			temp=temp/10;
			
		}
		if(newnum==num) {
			System.out.println((num)+" is a Palindrome Number");
		}else {
			System.out.println("Not a pailindrome number");
			
		}
		palindromechecker.close();
		
	}

}
