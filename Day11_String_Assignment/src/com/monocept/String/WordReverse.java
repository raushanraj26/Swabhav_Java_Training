package com.monocept.String;

import java.util.Scanner;

public class WordReverse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  Scanner sc = new Scanner(System.in);

	        System.out.print("Enter a sentence: ");
	        String s = sc.nextLine();

	        String[] words = s.split(" ");

	        for(int i = 0; i < words.length; i++) {

	            String word = words[i];

	            for(int j = word.length() - 1; j >= 0; j--) {
	                System.out.print(word.charAt(j));
	            }

	            System.out.print(" ");
	        }

	}

}
