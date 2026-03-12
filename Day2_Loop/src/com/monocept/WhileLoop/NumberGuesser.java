package com.monocept.WhileLoop;

import java.util.Random;
import java.util.Scanner;

public class NumberGuesser {
    public static void main(String[] args) {

        Scanner numberguesser = new Scanner(System.in);
        Random rand = new Random();

        int num = rand.nextInt(100) + 1;
        int attempt = 0;
        int guess = 0;

        System.out.println("Guess Number between 1 to 100");

        while (guess != num) {
            attempt++;
            while (true) {

                System.out.print("Guess Number: ");

                if (numberguesser.hasNextInt()) {
                    guess = numberguesser.nextInt();
                    break;   // correct input → exit loop
                } 
                else {
                    System.out.println("Please enter numbers only!");
                    numberguesser.next();   // remove wrong input
                }
            }

            if (guess < num) {
                System.out.println("Sorry, too Low");
            } else if (guess > num) {
                System.out.println("Sorry, too High");
            }
        }

        System.out.println("You won in attempt " + attempt + " ! and Number is "+ num);
        numberguesser.close();
    }
}
