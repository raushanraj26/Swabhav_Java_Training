package com.monocept.ProductInventoryAndCategory.model;

public class Electronics extends Product {
	private int warrantyYears;
	
	//constructors
	public Electronics(String productid, String productname,double baseprice,int warrantyYears) {
		super(productid,productname,baseprice);  //calling parent constructors for initialising common fields
		this.warrantyYears=warrantyYears;
	}
	
	//implementing abstract methods
	
@Override
public void displayDetails() {

  //  System.out.println("Product ID: " + productid); //The field Product.productid is not visible because private field
	System.out.println("Product ID: " + getProductId());
    System.out.println("Product Name: " + getProductName());
    System.out.println("Price: " + getBasePrice());
    System.out.println("Warranty: " + warrantyYears);
}

}
