package com.SudokuValidator.model;

public class SudokuGrid {

    private int[][] grid;

    public SudokuGrid(int[][] grid) {
        this.grid = grid;
    }

    public int[][] getGrid() {
        return grid;
    }

    public void printGrid() {

        System.out.println("\nCurrent Sudoku Board:");

        for (int i = 0; i < 9; i++) {

            for (int j = 0; j < 9; j++) {
                System.out.print(grid[i][j] + " ");
            }

            System.out.println();
        }
    }

}