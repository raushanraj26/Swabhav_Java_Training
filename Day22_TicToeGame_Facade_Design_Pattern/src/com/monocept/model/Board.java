package com.monocept.model;

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
	    
	    public char[][] getGrid() {
	        return grid;
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

	    

}
