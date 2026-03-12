package com.monocept.String;

import java.util.Scanner;

public class WordFrequencyCounter {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a sentence: ");
        String sentence = sc.nextLine();

     
        sentence = sentence.toLowerCase();

        
        String[] words = sentence.split(" ");

        
        for (int i = 0; i < words.length; i++) {

            int count = 1;

            // check already count
            if (words[i].equals("0")) {
                continue;
            }

            for (int j = i + 1; j < words.length; j++) {

                if (words[i].equals(words[j])) {
                    count++;
                    words[j] = "0"; // mark 0 as alrready count
            }

            
            System.out.println(words[i] + " : " + count);
        }

        sc.close();
    }
}
