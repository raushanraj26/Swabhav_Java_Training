//DRY-Don't repeat urself,you write same code twice → Put it in a method.
//Make reusable,readable,easy to debug 



package com.monocept;



public class DryEx {
	static void checkEvenOdd(int num) {
	    if (num % 2 == 0) {
	        System.out.println(num + " is Even");
	    } else {
	        System.out.println(num + " is Odd");
	    }
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		checkEvenOdd(5);
        checkEvenOdd(10);

	}

}
