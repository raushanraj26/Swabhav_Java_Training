package com.monocept.TicTocToeGame.model;

public class Board {
	 private char[][] grid;

	    public Board() {
	        grid = new char[3][3];

	        // Initialize board with empty space
	        int num=0;
	        for(int i = 0; i < 3; i++) {
	            for(int j = 0; j < 3; j++) {
	                grid[i][j] =(char) (num + '0') ;
	                num++;
	            }
	        }
	    }
	    
	    //print the boad
	    public void displayBoard() {
	        for(int i = 0; i < 3; i++) {
	            for(int j = 0; j < 3; j++) {
	                System.out.print(grid[i][j]);
	                if(j < 2) {
	                    System.out.print(" | ");
	                }
	            }
	            System.out.println();
	            if(i < 2) {
	                System.out.println("---------");
	            }
	        }
	    }
	    
	    //check select box is empty or not
	    public boolean placeMove(int row, int col, char symbol) {
	        if(grid[row][col] != 'X' &&  grid[row][col] != 'O') {
	            grid[row][col] = symbol;
	            return true;
	        }
	        return false;
	    }

	    public boolean checkWinner(char symbol) {

	        // Check rows
	        for(int i = 0; i < 3; i++) {
	            if(grid[i][0] == symbol &&
	               grid[i][1] == symbol &&
	               grid[i][2] == symbol) {
	                return true;
	            }
	        }

	        // Check columns
	        for(int j = 0; j < 3; j++) {
	            if(grid[0][j] == symbol &&
	               grid[1][j] == symbol &&
	               grid[2][j] == symbol) {
	                return true;
	            }
	        }

	        // Check diagonals
	        if(grid[0][0] == symbol &&
	           grid[1][1] == symbol &&
	           grid[2][2] == symbol) {
	            return true;
	        }

	        if(grid[0][2] == symbol &&
	           grid[1][1] == symbol &&
	           grid[2][0] == symbol) {
	            return true;
	        }

	        return false;
	    }

	    public boolean isBoardFull() {
	        for(int i = 0; i < 3; i++) {
	            for(int j = 0; j < 3; j++) {
	                if(grid[i][j] != 'X' &&  grid[i][j] != 'O') {
	                    return false;
	                }
	            }
	        }
	        return true;
	    }
	    

}
