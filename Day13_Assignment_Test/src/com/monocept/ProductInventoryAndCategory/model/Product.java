package com.monocept.ProductInventoryAndCategory.model;

 public abstract class Product {
	 private final String productid;
	 private final String productname;
	 private double baseprice;
	 
	 //constructor
	 public Product(String productid, String productname,double baseprice) {
		 this.productid=productid;
		 this.productname=productname;
		 this.baseprice=baseprice;
	 }
	 
	 public String getProductId() {
	        return productid;
	    }

	    public String getProductName() {
	        return productname;
	    }

	    public double getBasePrice() {
	        return baseprice;
	    }
	 
	 public abstract void displayDetails();
	 

}
