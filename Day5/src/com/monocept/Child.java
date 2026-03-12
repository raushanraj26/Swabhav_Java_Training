package com.monocept;

public class Child extends Parent {
	
	
//	Child() {
//        super();   
//       this();
//    }
	
//	
//	Child() {
//		this();
//   super();   
//  
//  }
	
	
	
	  Child() {
	        this(10);   
	        System.out.println("Default Child Constructor");
	    }

	    Child(int x) {
	        super();    
	        System.out.println("Parameterized Child Constructor");
	    }
	    
	    
	    public static void main(String[] args) {
	        Child ch = new Child();   
	    }

	
	}
	


