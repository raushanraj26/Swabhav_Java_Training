package com.monocept.TicTocToeGame;
import java.util.Scanner; 
class TicTocToe {
	public static void main(String[] args) {
		char[][] board=new char[3][3];
		for(int row=0;row<board.length;row++) {
			for(int col=0;col<board[row].length;col++) {
				board[row][col]=' ';
			}
		}
		char player='X';
		boolean gameover=false;
		Scanner scanner=new Scanner(System.in);
		while(!gameover) {
			printboard(board);
			int row;
			int col;
			
			do {
				System.out.println("Player " + player + " enter(row & col): ");
				 row=scanner.nextInt();
				 col=scanner.nextInt();
			}while(row>=3 || col >=3);
			//check the given input box wheter it is empty or already filled
			if(board[row][col]==' ') {
				//place the element
				board[row][col]=player; //either X or 0
				gameover=havewon(board,player);
				//check wheter win or not
				if(gameover) {
					System.out.println("Player "+player + " has Won! ");
					
				}else {
					//switch the player
					player=(player=='X')?'O':'X';
					
				}
				
			}else {
				System.out.println("Invalid Move.Try again!");
			}
			
		}
		printboard(board);
	}
	public static boolean havewon(char[][] board,char player) {
		for(int row=0;row<board.length;row++) {
			if(board[row][0]==player &&board[row][1]==player && board[row][2]==player) {
				return true;
			}
		}
		for(int col=0;col<board[0].length;col++) {
			if(board[0][col]==player &&board[1][col]==player && board[2][col]==player) {
				return true;
			}
		}
		if(board[0][0]==player && board[1][1]==player && board[2][2]==player) {
			return true;
		}
		if(board[0][1]==player && board[1][1]==player && board[1][0]==player) {
			return true;
		}
		
		return false;
		
		
	}
	public static void printboard(char[][] board) {
		for(int row=0;row<board.length;row++) {
			for(int col=0;col<board[row].length;col++) {
				System.out.print(board[row][col] +"|");
				
			}
			System.out.println();
		}
		
	}

}
