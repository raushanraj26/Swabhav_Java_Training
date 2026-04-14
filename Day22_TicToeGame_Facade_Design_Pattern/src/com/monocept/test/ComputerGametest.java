package com.monocept.test;

import com.monocept.Facade.*;

import java.util.Random;
import java.util.Scanner;

import com.monocept.Facade.GameFacade;

public class ComputerGametest {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Random rand = new Random();

		GameFacade facade = new GameFacade();

		// hum player 
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
		sc.nextLine();

		// Set players- human + computer
		facade.setPlayers(name1, humanSymbol, "Computer");

		System.out.println("\nGame Started!");
		System.out.println(facade.getPlayer1Name() + " is " + facade.getPlayer1Symbol());
		System.out.println(facade.getPlayer2Name() + " is " + facade.getPlayer2Symbol());

		// Main loop
		while (true) {
			System.out.println("\nTurn: " + facade.currentPlayerName());
			facade.displayBoard();

			int position;

			// chech turn of  computer turn by checking current symbol
			if (facade.currentPlayerSymbol() == facade.getPlayer2Symbol()) {
				System.out.println("It's Computer's turn...");

				while (true) {
					position = rand.nextInt(9);
					if (facade.isPositionEmpty(position)) {
						System.out.println("Computer chose position: " + position);
						break;
					}
				}

			} else {
				// Human move
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

						break;
					} else {
						System.out.println("Invalid input! Enter a number.");
						sc.next(); // clear invalid token
					}
				}
			}

			// Apply move through Facade (this also checks win/draw & switches player internally)
			boolean gameOver = facade.makeMove(position);
			if (gameOver)
				break;
		}

		sc.close();
	}
}
