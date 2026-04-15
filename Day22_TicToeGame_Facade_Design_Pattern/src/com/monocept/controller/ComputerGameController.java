package com.monocept.controller;


import java.util.Random;
import java.util.Scanner;

import com.monocept.Facade.GameFacade;

public class ComputerGameController {

    private Scanner sc;
    private GameFacade facade;
    private Random rand;

    public ComputerGameController() {
        sc = new Scanner(System.in);
        rand = new Random();
    }

    public void start() {

        facade = new GameFacade();

        setupHumanPlayer();
        startGameLoop();

        sc.close();
    }

    // human setup
    private void setupHumanPlayer() {

        System.out.print("Enter your name: ");
        String name1 = sc.nextLine().trim();

        while (!facade.validateName(name1)) {
            System.out.print("Again enter your name: ");
            name1 = sc.nextLine().trim();
        }

        System.out.print("Choose your symbol (X or O): ");
        char humanSymbol = Character.toUpperCase(sc.next().charAt(0));

        while (!facade.validateSymbol(humanSymbol)) {
            System.out.print("Again choose symbol (X or O): ");
            humanSymbol = Character.toUpperCase(sc.next().charAt(0));
        }

        sc.nextLine(); // clear buffer

        facade.setPlayers(name1, humanSymbol, "Computer");

        System.out.println("\nGame Started!");
        System.out.println(facade.getPlayer1Name() + " is " + facade.getPlayer1Symbol());
        System.out.println(facade.getPlayer2Name() + " is " + facade.getPlayer2Symbol());
    }

    //game loop
    private void startGameLoop() {

        while (true) {

            System.out.println("\nTurn: " + facade.currentPlayerName());
            facade.displayBoard();

            int position;

            if (isComputerTurn()) {
                position = getComputerMove();
            } else {
                position = getHumanMove();
            }

            boolean gameOver = facade.makeMove(position);

            if (gameOver)
                break;
        }
    }

    // ================= TURN CHECK =================
    private boolean isComputerTurn() {
        return facade.currentPlayerSymbol() == facade.getPlayer2Symbol();
    }

    // ================= COMPUTER MOVE =================
    private int getComputerMove() {

        System.out.println("It's Computer's turn...");

        int position;

        while (true) {
            position = rand.nextInt(9);

            if (facade.isPositionEmpty(position)) {
                System.out.println("Computer chose position: " + position);
                return position;
            }
        }
    }

    // ================= HUMAN MOVE =================
    private int getHumanMove() {

        int position;

        while (true) {
            System.out.print("Enter position (0-8): ");

            if (sc.hasNextInt()) {
                position = sc.nextInt();

                if (!facade.validatePosition(position)) {
                    System.out.println("Enter between 0-8");
                    continue;
                }

                if (!facade.isPositionEmpty(position)) {
                    System.out.println("Position already filled!");
                    continue;
                }

                return position;

            } else {
                System.out.println("Invalid input! Enter a number.");
                sc.next(); // clear invalid
            }
        }
    }
}
