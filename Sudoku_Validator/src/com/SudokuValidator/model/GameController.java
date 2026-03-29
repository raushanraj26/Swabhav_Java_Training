package com.SudokuValidator.model;


import java.util.Scanner;

public class GameController {

	Board board = new Board();
	Scanner sc = new Scanner(System.in);

	public void startGame() {


		while (true) {

			System.out.println("1. Start Game");
			System.out.println("2. Exit");
			if (!sc.hasNextInt()) {
				System.out.println("Enter valid choice");
				sc.next();
				continue;
			}
			int option = sc.nextInt();

			if (option == 2) {
				System.out.println("Thanks for playing!");
				System.exit(0);
			}

			if (option != 1) {
				System.out.println("Invalid choice!");
				continue;
			}

			while(true) {
				System.out.println("Enter the difficulty: ");
				System.out.println("1. Easy");
				System.out.println("2. Medium");
				System.out.println("3. Hard");

				if (!sc.hasNextInt()) {
					System.out.println("Enter valid choice");
					sc.next();
					continue;
				}
				int choice = sc.nextInt();
				Difficulty level;
				if (choice == 1)
					level = Difficulty.EASY;
				else if (choice == 2)
					level = Difficulty.MEDIUM;
				else
					level = Difficulty.HARD;
				board.loadBoard(level);
				gameLoop();
				break;
			}

		}
	}

	void gameLoop() {

		while (true) {

			board.printBoard();

			if (board.isComplete()) {
				System.out.println(" Congratulations! You solved Sudoku!");
				break;
			}

			System.out.println("Enter row,col and number (1-9) or 0 to exit:");
			if (!sc.hasNextInt()) {
				System.out.println("Enter valid row number");
				sc.next();
				continue;
			}
			int r = sc.nextInt();

			if (r == 0)
				break;
			if (!sc.hasNextInt()) {
				System.out.println("Enter valid column number");
				sc.next();
				continue;
			}
			int c = sc.nextInt();
			
			if (!sc.hasNextInt()) {
				System.out.println("Enter valid number");
				sc.next();
				continue;
			}
			//--Range validate--
			if (r < 1 || r > 9 || c < 1 || c > 9) {
			    System.out.println("Row and Column must be between 1 and 9");
			    continue;
			}

			
			int num = sc.nextInt();
			
			
			if (num < 1 || num > 9) {
			    System.out.println("Number must be between 1 and 9");
			    continue;
			}
			

			r--;
			c--;

			if (board.isFixedCell(r, c)) {
				System.out.println("Cannot change fixed cell!");
				continue;
			}

			if (num < 1 || num > 9) {
				System.out.println(" Invalid number!");
				continue;
			}

			if (InputValidator.isValidMove(board, r, c, num)) {
				board.setValue(r, c, num);
			} else {
				System.out.println(" Invalid move!");
			}
		}
	}
}
