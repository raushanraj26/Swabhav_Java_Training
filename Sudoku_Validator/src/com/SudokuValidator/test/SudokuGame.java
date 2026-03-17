package com.SudokuValidator.test;

import java.util.Scanner;
import com.SudokuValidator.model.*;

public class SudokuGame {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[][] board = {

                {5,3,0,0,7,0,0,0,0},
                {6,0,0,1,9,5,0,0,0},
                {0,9,8,0,0,0,0,6,0},

                {8,0,0,0,6,0,0,0,3},
                {4,0,0,8,0,3,0,0,1},
                {7,0,0,0,2,0,0,0,6},

                {0,6,0,0,0,0,2,8,0},
                {0,0,0,4,1,9,0,0,5},
                {0,0,0,0,8,0,0,7,9}
        };

        SudokuGrid grid = new SudokuGrid(board);
        SudokuValidator validator = new SudokuValidator();

        while (true) {

            grid.printGrid();

            System.out.println("\nEnter row (0-8): ");
            int row = sc.nextInt();

            System.out.println("Enter column (0-8): ");
            int col = sc.nextInt();

            System.out.println("Enter number (1-9): ");
            int num = sc.nextInt();

            board[row][col] = num;

            if (validator.validate(board)) {
                System.out.println("Move accepted");
            } else {
                System.out.println("Invalid move! Rule broken");
                board[row][col] = 0;
            }

        }

    }

}
