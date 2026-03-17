package com.SudokuValidator.model;

class InvalidSudokuException extends Exception {
	private static final long serialVersionUID = 1L;

    public InvalidSudokuException(String message) {
        super(message);
    }

}
