package com.SudokuValidator.model;

public class SudokuValidator {

    public boolean validateSudoku(int[][] grid) throws InvalidSudokuException {

        if (grid.length != 9) {
            throw new InvalidSudokuException("Grid must be 9x9");
        }

        if (!checkRows(grid)) {
            System.out.println("Invalid: Duplicate in row");
            return false;
        }

        if (!checkColumns(grid)) {
            System.out.println("Invalid: Duplicate in column");
            return false;
        }

        if (!checkBoxes(grid)) {
            System.out.println("Invalid: Duplicate in 3x3 box");
            return false;
        }

        return true;
    }

    private boolean checkRows(int[][] grid) {

        for (int i = 0; i < 9; i++) {

            boolean[] visited = new boolean[10];

            for (int j = 0; j < 9; j++) {

                int num = grid[i][j];

                if (visited[num]) {
                    return false;
                }

                visited[num] = true;
            }
        }

        return true;
    }

    private boolean checkColumns(int[][] grid) {

        for (int i = 0; i < 9; i++) {

            boolean[] visited = new boolean[10];

            for (int j = 0; j < 9; j++) {

                int num = grid[j][i];

                if (visited[num]) {
                    return false;
                }

                visited[num] = true;
            }
        }

        return true;
    }

    private boolean checkBoxes(int[][] grid) {

        for (int row = 0; row < 9; row += 3) {

            for (int col = 0; col < 9; col += 3) {

                boolean[] visited = new boolean[10];

                for (int i = row; i < row + 3; i++) {

                    for (int j = col; j < col + 3; j++) {

                        int num = grid[i][j];

                        if (visited[num]) {
                            return false;
                        }

                        visited[num] = true;
                    }
                }
            }
        }

        return true;
    }
}