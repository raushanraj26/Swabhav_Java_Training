package com.SudokuValidator.model;


public class InputValidator {

    public static boolean isValidMove(Board board,int row,int col,int num){

        return checkRow(board,row,num)
            && checkColumn(board,col,num)
            && checkBox(board,row,col,num);
    }

    static boolean checkRow(Board board,int row,int num){

        for(int i=0;i<9;i++)
            if(board.grid[row][i]==num) {
            	System.out.println("Number exit in Row");
                return false;
            }
        return true;
    }

    static boolean checkColumn(Board board,int col,int num){

        for(int i=0;i<9;i++)
        	
            if(board.grid[i][col]==num) {
            	System.out.println("Number exit in Column");
                return false;
            }
        return true;
    }

    static boolean checkBox(Board board,int row,int col,int num){

        int startRow=row-row%3;
        int startCol=col-col%3;

        for(int i=startRow;i<startRow+3;i++)
            for(int j=startCol;j<startCol+3;j++)
                if(board.grid[i][j]==num) {
                	System.out.println("Number exit in Block");
                    return false;
                }
        return true;
    }
}
