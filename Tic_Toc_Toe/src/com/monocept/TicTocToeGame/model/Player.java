package com.monocept.TicTocToeGame.model;

public class Player {
	private String name;
	private char symbol;
	public Player(String name,char symbol) {
		this.name=name;
		this.symbol=symbol;
	}
	
	//geeter for name
	public String getName() {
		return name;
	}
	 // Getter for symbol
    public char getSymbol() {
        return symbol;
    }
	

}
