package com.monocept.model;


public class Player {
	private String name;
	private char symbol;
	public Player(String name,char symbol) {
		this.name=name;
		this.symbol=symbol;
	}
	
	//getter for name
	public String getName() {
		return name;
	}
	 // getter for symbol
    public char getSymbol() {
        return symbol;
    }
	

}
