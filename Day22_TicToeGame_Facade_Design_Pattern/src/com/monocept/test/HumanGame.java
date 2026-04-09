package com.monocept.test;

import java.util.Scanner;
import com.monocept.Facade.GameFacade;

public class HumanGame {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) { 

            GameFacade facade = new GameFacade();
            

            // Player 1
            System.out.print("Enter the name of first player: ");
            String name1=sc.nextLine().trim();
            
            while(!facade.validateName(name1)) {
            	System.out.print("Again Enter the name of first player: ");
            	name1=sc.nextLine().trim();
            }

            System.out.print("Enter symbol (X or O): ");
            char symbol1=Character.toUpperCase(sc.next().charAt(0));
            while (!facade.validateSymbol(symbol1)) {
                System.out.print("Again Enter symbol (X or O): ");
                symbol1 = Character.toUpperCase(sc.next().charAt(0));
            }

            sc.nextLine();

            // Player 2
            System.out.print("Enter the name of second player: ");
            String name2 = sc.nextLine().trim();
            while (!facade.validateName(name2)) {
                System.out.print("Again Enter the name of second player: ");
                name2 = sc.nextLine().trim();
            }
            
            facade.setPlayers(name1, symbol1, name2);

            System.out.println("\nGame Started!");
            System.out.println(facade.getPlayer1Name() + " is " + facade.getPlayer1Symbol());
            System.out.println(facade.getPlayer2Name() + " is " + facade.getPlayer2Symbol());

            // Game Loop
            while (true) {

                System.out.println("\nTurn: " + facade.currentPlayerName());
                facade.displayBoard();

                int position;

                while (true) {
                    System.out.print("Enter position (0-8): ");

                    if (sc.hasNextInt()) {
                        position = sc.nextInt();

                        if (position >= 0 && position <= 8) break;
                        else System.out.println("Enter between 0-8");
                    } else {
                        System.out.println("Invalid input!");
                        sc.next();
                    }
                }

                boolean gameOver = facade.makeMove(position);

                if (gameOver) break; 
            }

            //ask for continue or not
            System.out.print("Do you want to play again? (Y/N): ");
            char choice = sc.next().charAt(0);
            sc.nextLine(); 

            if (choice == 'N' || choice == 'n') {
                System.out.println("Thanks for playing!");
                break;
            }
        }

        sc.close();
    }
}