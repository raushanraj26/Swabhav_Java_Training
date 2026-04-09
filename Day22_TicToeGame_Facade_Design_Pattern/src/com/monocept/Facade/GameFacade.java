package com.monocept.Facade;

import com.monocept.model.Board;
import com.monocept.model.GameLogic;
import com.monocept.model.InputHandler;
import com.monocept.model.Player;

public class GameFacade {
	private Board board;
	private InputHandler validate;
	private GameLogic logic;
	private Player player1;
	private Player player2;
	private Player currplayer;

	public GameFacade() {
		board = new Board();
		logic = new GameLogic();
		validate=new InputHandler();
	}

	public void displayBoard() {
	    board.displayBoard();
	}
	public void setPlayers(String name1, char symbol1, String name2) {
		player1 = new Player(name1, symbol1);
		char symbol2 = (symbol1 == 'X') ? 'O' : 'X';
		player2 = new Player(name2, symbol2);

		// first turn start with player 1
		currplayer = player1;

	}

	public boolean makeMove(int position) {

		int row = position / 3;
		int col = position % 3;

		boolean isValid = board.placeMove(row, col, currplayer.getSymbol());

		if (!isValid) {
			System.out.println("This position is already filled. Try again.");
			return false;
		}
		board.displayBoard();
		// check winner
		if (logic.checkWinner(board.getGrid(), currplayer.getSymbol())) {
			board.displayBoard();
			System.out.println("Winner is: " + currplayer.getName());
			return true;
		}

		// check draw
		if (logic.isBoardFull(board.getGrid())) {
			board.displayBoard();
			System.out.println("Match is a Draw!");
			return true;
		}

		// switch player
		currplayer = (currplayer == player1) ? player2 : player1;
		 return false;
	}
	public  String getPlayer1Name() {
		return player1.getName();
	}

	public  char getPlayer1Symbol() {
		return player1.getSymbol();
	}
	
	public  String getPlayer2Name() {
		return player2.getName();
	}

	public  char getPlayer2Symbol() {
		return player2.getSymbol();
	}
	
	public  String currentPlayerName() {
		return currplayer.getName();
	}
	public boolean validateName(String name) {
		return validate.validateName(name);
	}
	
	public boolean validateSymbol(char symbol) {
		return validate.validateSymbol(symbol);
	}

}
