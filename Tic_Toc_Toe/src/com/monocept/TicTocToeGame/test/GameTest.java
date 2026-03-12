package com.monocept.TicTocToeGame.test;

import java.util.Scanner;

import com.monocept.TicTocToeGame.model.Board;
import com.monocept.TicTocToeGame.model.Player;

public class GameTest {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Board board = new Board();

        //  Player 1 Input 
        System.out.print("Enter the name of first player: ");
        String name1 = sc.nextLine();

        char symbol1;
        while (true) {
            System.out.print("Enter symbol for first player (X or O): ");
            symbol1 = sc.next().charAt(0);
            symbol1 = Character.toUpperCase(symbol1);

            if (symbol1 == 'X' || symbol1 == 'O') {
                break;
            } else {
                System.out.println("Invalid symbol! Please choose X or O.");
            }
        }

        sc.nextLine(); 

        //Player 2 Input
        System.out.print("Enter the name of second player: ");
        String name2 = sc.nextLine();

        // ternary operator, assign opposite symbol
        char symbol2 = (symbol1 == 'X') ? 'O' : 'X';

        Player player1 = new Player(name1, symbol1);
        Player player2 = new Player(name2, symbol2);

        Player currplayer = player1;

        System.out.println("\nGame Started!");
        System.out.println(player1.getName() + " is " + player1.getSymbol());
        System.out.println(player2.getName() + " is " + player2.getSymbol());

        //  Game Loop 
        while (true) {

            board.displayBoard();

            System.out.println("\nIt's turn of " + currplayer.getName());

//            int row, col;
//
//            //  Row Validation 
//            while (true) {
//                System.out.print("Enter row (0-2): ");
//                if (sc.hasNextInt()) {
//                    row = sc.nextInt();
//                    if (row >= 0 && row <= 2) {
//                        break;
//                    } else {
//                        System.out.println("Row must be between 0 and 2.");
//                    }
//                } else {
//                    System.out.println("Please enter a valid number.");
//                    sc.next(); // remove wrong input
//                }
//            }
//
//            // Column Validation 
//            while (true) {
//                System.out.print("Enter column (0-2): ");
//                if (sc.hasNextInt()) {
//                    col = sc.nextInt();
//                    if (col >= 0 && col <= 2) {
//                        break;
//                    } else {
//                        System.out.println("Column must be between 0 and 2.");
//                    }
//                } else {
//                    System.out.println("Please enter a valid number.");
//                    sc.next(); // remove wrong input
//                }
//            }

            int position;

            while (true) {
                System.out.print("Enter position (0-8): ");

                if (sc.hasNextInt()) {
                    position = sc.nextInt();

                    if (position >= 0 && position <= 8) {
                        break;
                    } else {
                        System.out.println("Position must be between 0 and 8.");
                    }
                } else {
                    System.out.println("Please enter a valid number.");
                    sc.next(); // remove wrong input
                }
            }

            // Convert position to row and column
            int row = position / 3;
            int col = position % 3;
            boolean isValid = board.placeMove(row, col, currplayer.getSymbol());

            if (!isValid) {
                System.out.println("This position is already filled. Try again.");
                continue;
            }

            // Check winner
            if (board.checkWinner(currplayer.getSymbol())) {
                board.displayBoard();
                System.out.println("Winner is: " + currplayer.getName());
                break;
            }

            // Check draw
            if (board.isBoardFull()) {
                board.displayBoard();
                System.out.println("Match is a Draw!");
                break;
            }

            // Switch player
            if (currplayer == player1) {
                currplayer = player2;
            } else {
                currplayer = player1;
            }
        }

        sc.close();
    }
}














//package com.monocept.TicTocToeGame.test;
//
//import java.util.Scanner;
//
//import com.monocept.TicTocToeGame.model.Board;
//import com.monocept.TicTocToeGame.model.Player;
//
//public class GameTest {
//	public static void main(String[] args) {
//		Scanner sc=new Scanner(System.in);
//		//create board
//		
//		Board board = new Board();
//		//create two player
//		System.out.print("Enter the name of first player");
//		String name1=sc.nextLine();
//		System.out.print("Enter the Symbol of first player.(X or O");
//		char symbol1=sc.next().charAt(0);
//		
//		System.out.print("Enter the name of Second player");
//		String name2=sc.nextLine();
//		System.out.print("Enter the Symbol of second player.(X or O");
//		char symbol2=sc.next().charAt(0);
//		
//		Player player1=new Player(name1,symbol1);
//		Player player2=new Player(name2,symbol2);
//		Player currplayer=player1;
//		do {
//			board.displayBoard();
//			System.out.print("ITS move to " + currplayer.getname());
//			System.out.print("Enter row number");
//			int row=sc.nextInt();
//			System.out.print("Enter column number");
//			int col=sc.nextInt();
//			if(row>2 || col>2) {
//				System.out.print("Enter valid Row or col");
//				return;
//			}
//			
//			boolean isvalid=board.placeMove(row, col, currplayer.getSymbol());
//			if(!isvalid) {
//				System.out.print("this place already fill");
//				return;
//				
//			}else {
//				System.out.println("Display the board after  putting the xurrent symbol:");
//				board.displayBoard();
//			}
//			
//			boolean iswinner=board.checkWinner(currplayer.getSymbol());
//			if(iswinner) {
//				System.out.print("Winner is: "+ currplayer +"has symbol: "+currplayer.getSymbol());
//				break;
//			}
//			boolean isdraw=board.isBoardFull();
//			if(isdraw) {
//				System.out.print("Match is draw");
//				break;
//			}
//			if(currplayer==player1) {
//				currplayer=player1;
//				
//			}else {
//				currplayer=player2;
//				
//			}
//			
//		}while(true);
//		
//		
//		
//	}
//
//}
