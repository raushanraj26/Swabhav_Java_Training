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
            System.out.print("Guess Number: ");
            guess = numberguesser.nextInt();

            if (guess < num) {
                System.out.println("Sorry, too Low");
            } else if (guess > num) {
                System.out.println("Sorry, too High");
            }
        }

        System.out.println("You won in attempt " + attempt);
        numberguesser.close();
    }
}
