package com.swabhav.model;

import java.util.Scanner;

public class primeNotprimeChecker {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
        System.out.print("Enter an Integer");
        int num=scanner.nextInt();
        if(num<=1) {
       	 System.out.println("Given number is Not Prime");
        }else {
       	 boolean prime=true;
       	 for(int i=2;i*i<=num;i++) {
       		 if(num%i==0) {
       			 prime=false;
       			 break;
       		 }
       	 }
       	 if(prime) {
       		System.out.println("Prime number");
       	 }else {
       		System.out.println("Not a Prime number");
       	 }
       	 
        }
        scanner.close();
	}

}
