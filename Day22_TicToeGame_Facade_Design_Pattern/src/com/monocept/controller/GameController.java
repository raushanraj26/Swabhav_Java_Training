package com.monocept.controller;

import java.util.Scanner;
import com.monocept.Facade.GameFacade;

public class GameController {

    private Scanner sc;
    private GameFacade facade;

    public GameController() {
        sc = new Scanner(System.in);
    }

    // Entry method
    public void start() {
        while (true) {

            facade = new GameFacade();

            setupPlayers();
            startGameLoop();

            if (!askReplay())
                break;
        }

        sc.close();
    }

    // ================= PLAYER SETUP =================
    private void setupPlayers() {

        // Player 1
        System.out.print("Enter the name of first player: ");
        String name1 = sc.nextLine().trim();

        while (!facade.validateName(name1)) {
            System.out.print("Again Enter the name of first player: ");
            name1 = sc.nextLine().trim();
        }

        System.out.print("Enter symbol (X or O): ");
        char symbol1 = Character.toUpperCase(sc.next().charAt(0));

        while (!facade.validateSymbol(symbol1)) {
            System.out.print("Again Enter symbol (X or O): ");
            symbol1 = Character.toUpperCase(sc.next().charAt(0));
        }

        sc.nextLine(); // clear buffer

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
    }

    // ================= GAME LOOP =================
    private void startGameLoop() {

        while (true) {

            System.out.println("\nTurn: " + facade.currentPlayerName());
            facade.displayBoard();

            int position = getValidPosition();

            boolean gameOver = facade.makeMove(position);

            if (gameOver)
                break;
        }
    }

    // ================= INPUT VALIDATION =================
    private int getValidPosition() {

        int position;

        while (true) {
            System.out.print("Enter position (0-8): ");

            if (sc.hasNextInt()) {
                position = sc.nextInt();

                if (facade.validatePosition(position)) {
                    return position;
                } else {
                    System.out.println("Enter between 0-8");
                }

            } else {
                System.out.println("Invalid input!");
                sc.next(); // clear wrong input
            }
        }
    }

    // ================= REPLAY =================
    private boolean askReplay() {

        System.out.print("Do you want to play again? (Y/N): ");
        char choice = sc.next().charAt(0);
        sc.nextLine(); // clear buffer

        if (choice == 'N' || choice == 'n') {
            System.out.println("Thanks for playing!");
            return false;
        }

        return true;
    }
}