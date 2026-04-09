package com.monocept.model;

public class InputHandler {
	public boolean validateName(String name) {
		 if (name.isEmpty()) {
			 return false;
			 
		 }
		 return true;
	}
	
	public boolean validateSymbol(char symbol) {
		if (symbol == 'X' || symbol == 'O') {
			return true;
			
		}
		return false;
	}
	

}
