package com.monocept.TicTocToeGame.test;

import java.util.Random;
import java.util.Scanner;

import com.monocept.TicTocToeGame.model.Board;
import com.monocept.TicTocToeGame.model.Player;
public class ComputerGametest {
	 public static void main(String[] args) {

	        Scanner sc = new Scanner(System.in);
	        Random rand = new Random();

	        Board board = new Board();

	        System.out.print("Enter your name: ");
	        String name = sc.nextLine();

	        char symbol;
	        while (true) {
	            System.out.print("Choose your symbol (X or O): ");
	            symbol = sc.next().charAt(0);
	            symbol = Character.toUpperCase(symbol);

	            if (symbol == 'X' || symbol == 'O')
	                break;
	            else
	                System.out.println("Invalid symbol. Choose X or O.");
	        }

	        char botSymbol = (symbol == 'X') ? 'O' : 'X';

	        Player human = new Player(name, symbol);
	        Player bot = new Player("Computer", botSymbol);

	        Player current = human;

	        System.out.println("\nGame Started!");

	        while (true) {

	            board.displayBoard();

	            int row, col;

	            if (current == human) {

	                int position;

	                while (true) {
	                    System.out.print("Enter position (0-8): ");

	                    if (sc.hasNextInt()) {
	                        position = sc.nextInt();

	                        if (position >= 0 && position <= 8)
	                            break;
	                        else
	                            System.out.println("Enter number between 0 and 8");
	                    } else {
	                        System.out.println("Enter valid number");
	                        sc.next();
	                    }
	                }

	                row = position / 3;
	                col = position % 3;

	            } else {

	                System.out.println("its chance of computer...");
	                int position;
	                while (true) {

	                   position = rand.nextInt(9);

	                    row = position / 3;
	                    col = position % 3;

	                    if (board.placeMove(row, col, bot.getSymbol())) {
	                        System.out.println("Computer placed " + bot.getSymbol() + " at position: " + position);
	                        break;
	                    }
	                }

	                board.displayBoard();
	            }

	            if (current == human) {
	                if (!board.placeMove(row, col, human.getSymbol())) {
	                    System.out.println("Position already filled!");
	                    continue;
	                }
	            }

	            if (board.checkWinner(current.getSymbol())) {
	                board.displayBoard();
	                System.out.println(current.getName() + " wins!");
	                break;
	            }

	            if (board.isBoardFull()) {
	                board.displayBoard();
	                System.out.println("Match Draw!");
	                break;
	            }

	            current = (current == human) ? bot : human;
	        }

	        sc.close();
	    }
}
