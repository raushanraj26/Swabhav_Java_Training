package com.SudokuValidator.model;



public class Board {

    int[][] grid = new int[9][9];
    boolean[][] fixed = new boolean[9][9];

//  
    
    public void loadBoard(Difficulty level) {

        int[][] solvedBoard = {
            {5,3,4,6,7,8,9,1,2},
            {6,7,2,1,9,5,3,4,8},
            {1,9,8,3,4,2,5,6,7},

            {8,5,9,7,6,1,4,2,3},
            {4,2,6,8,5,3,7,9,1},
            {7,1,3,9,2,4,8,5,6},

            {9,6,1,5,3,7,2,8,4},
            {2,8,7,4,1,9,6,3,5},
            {3,4,5,2,8,6,1,7,9}
        };

        // Step 1: copy full board
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                grid[i][j] = solvedBoard[i][j];
                fixed[i][j] = true;
            }
        }

        // Step 2: decide difficulty
        int cellsToRemove;

        if(level == Difficulty.EASY)
            cellsToRemove = 26;
        else if(level == Difficulty.MEDIUM)
            cellsToRemove = 36;
        else
            cellsToRemove = 46;

        // Step 3: remove randomly
        java.util.Random rand = new java.util.Random();

        while(cellsToRemove > 0){
            int row = rand.nextInt(9);
            int col = rand.nextInt(9);

            if(grid[row][col] != 0){
                grid[row][col] = 0;
                fixed[row][col] = false;
                cellsToRemove--;
            }
        }
    }

    public void printBoard(){

        System.out.println("\n+-------+-------+-------+");

        for(int i=0;i<9;i++){

            for(int j=0;j<9;j++){

                if(j%3==0) System.out.print("| ");

                if(grid[i][j]==0)
                    System.out.print(". ");
                else
                    System.out.print(grid[i][j]+" ");
            }

            System.out.println("|");

            if((i+1)%3==0)
                System.out.println("+-------+-------+-------+");
        }
    }

    public boolean isFixedCell(int r,int c){
        return fixed[r][c];
    }

    public void setValue(int r,int c,int num){
        grid[r][c]=num;
    }

    public boolean isComplete(){

        for(int i=0;i<9;i++)
            for(int j=0;j<9;j++)
                if(grid[i][j]==0)
                    return false;

        return true;
    }
}
