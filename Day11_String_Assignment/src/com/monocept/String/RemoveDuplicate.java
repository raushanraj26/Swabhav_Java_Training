package com.monocept.String;

import java.util.Scanner;

public class RemoveDuplicate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter the input string: ");
		String s=sc.nextLine();
		String[] news=s.split(" ");
		String ans="";
		
		int j=0;
		for(int i=1;i<news.length;i++) {
			if(!news[i].equals(news[j])) {
				ans += news[j] + " ";
				j=i;
				
			}
			
		}
		ans += news[j];
		System.out.println(ans);

	}

}
