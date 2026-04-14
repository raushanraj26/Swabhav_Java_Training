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
	
	public boolean validatePosition(int position) {
		if (position >= 0 && position <= 8) {
			return true;
		}
		return false;
	}
	

}
