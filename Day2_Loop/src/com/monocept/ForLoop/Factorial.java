package com.monocept.ForLoop;

import java.util.Scanner;

public class Factorial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner factorialnumber = new Scanner(System.in);
		System.out.print("ENter Number:");
		int num = factorialnumber.nextInt();

		int fact = 1;
		for (int i = 1; i < num; i++) {
			fact *= i;

		}
		System.out.print("the factorial is:" + (fact));
		factorialnumber.close();
	}

}
