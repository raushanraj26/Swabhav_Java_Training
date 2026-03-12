package com.monocept.WhileLoop;


import java.util.Random;
import java.util.Scanner;

public class PigGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();

        int totalScore = 0;
        int turn = 0;

        for (turn = 1; totalScore < 20; turn++) {
            int turnScore = 0;
            System.out.println("TURN " + turn);

            for (;;) {
                System.out.print("Roll or hold? (r/h): ");
                char choice = scanner.next().toLowerCase().charAt(0);

                if (choice == 'r') {
                    int die = rand.nextInt(6) + 1;
                    System.out.println("Die: " + die);

                    if (die == 1) {
                        turnScore = 0;
                        System.out.println("Turn over. No score.\n");
                        break;
                    } else {
                        turnScore += die;
                    }

                } else if (choice == 'h') {
                    totalScore += turnScore;
                    System.out.println("Score for turn: " + turnScore);
                    System.out.println("Total score: " + totalScore + "\n");
                    break;
                } else {
                    System.out.println("Invalid choice. Enter r/h");
                }
            }
        }

        System.out.println("You finished in " + (turn - 1) + " turns!");
        System.out.println("Game over!");

        scanner.close();
    }
}
//import java.util.Scanner;
//import java.util.Random;
//
//
//public class PigGame {
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		Scanner piggame = new Scanner(System.in);
//		int tscore = 0;
//		Random rand = new Random();
//
//		int maxi=20;
//		int turn = 0;
//		
//		
//		while (tscore < maxi) {
//			turn++;
//			int score = 0;
//			while (true) {
//				System.out.print("Roll or hold? (r/h):");
//
//				String inp = piggame.next();
//				if (inp.equals("r")) {
//					int dice = rand.nextInt(6) + 1;
//					System.out.print(dice);
//					if (dice == 1) {
//						score = 0;
//						break;
//					} else {
//						score += dice;
//					}
//
//				} else {
//					break;
//				}
//
//			}
//			tscore += score;
////			if (tscore >= maxi) {
////				break;
////			}
//			System.out.print(tscore);
//
//		}
//		
//		System.out.print("You Won and Finished in " +(turn) +" " + "turns and score is " +(tscore));
//		piggame.close();
//	}
//
//}
