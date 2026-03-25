package com.SudokuValidator.model;



public class Board {

    int[][] grid = new int[9][9];
    boolean[][] fixed = new boolean[9][9];

    public void loadBoard(Difficulty level) {

        int[][] puzzle;

        if(level == Difficulty.EASY){
            puzzle = new int[][]{
            	{5,3,4,6,7,8,9,1,2},
                {6,7,2,1,9,5,3,4,8},
                {1,9,8,3,4,2,5,6,7},

                {8,5,9,7,6,1,4,2,3},
                {4,2,6,8,0,3,7,9,1},
                {7,1,3,9,2,4,8,5,6},

                {9,6,1,5,3,7,2,8,4},
                {2,8,7,4,1,9,6,3,5},
                {3,4,5,2,8,6,1,7,0}
            };
        }

        else if(level == Difficulty.MEDIUM){
            puzzle = new int[][]{
                {0,0,0,2,6,0,7,0,1},
                {6,8,0,0,7,0,0,9,0},
                {1,9,0,0,0,4,5,0,0},
                {8,2,0,1,0,0,0,4,0},
                {0,0,4,6,0,2,9,0,0},
                {0,5,0,0,0,3,0,2,8},
                {0,0,9,3,0,0,0,7,4},
                {0,4,0,0,5,0,0,3,6},
                {7,0,3,0,1,8,0,0,0}
            };
        }

        else{
            puzzle = new int[][]{
                {0,0,0,0,0,0,0,1,2},
                {0,0,0,0,3,5,0,0,0},
                {0,0,0,7,0,0,3,0,0},
                {0,0,1,0,0,0,0,0,0},
                {0,6,0,0,0,0,0,4,0},
                {0,0,0,0,0,0,5,0,0},
                {0,0,7,0,0,2,0,0,0},
                {0,0,0,6,4,0,0,0,0},
                {3,2,0,0,0,0,0,0,0}
            };
        }

        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){

                grid[i][j] = puzzle[i][j];

                if(puzzle[i][j] != 0){
                    fixed[i][j] = true;
                }

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
