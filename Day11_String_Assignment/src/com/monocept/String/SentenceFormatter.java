package com.monocept.String;

import java.util.Scanner;

public class SentenceFormatter {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a sentence: ");
        String sentence = sc.nextLine();

        
        sentence = sentence.trim();

        
        sentence = sentence.toLowerCase();

        
        sentence = sentence.substring(0,1).toUpperCase() + sentence.substring(1);

        
        sentence = sentence.replace("fun", "interesting");

        
        String words[] = sentence.split(" ");
        int count = words.length;

   
        String firstWord = words[0];
        String lastWord = words[words.length - 1];

       
        System.out.println("Formatted sentence: " + sentence);
        System.out.println("Total words: " + count);
        System.out.println("First word: " + firstWord);
        System.out.println("Last word: " + lastWord);

        sc.close();
    }
}