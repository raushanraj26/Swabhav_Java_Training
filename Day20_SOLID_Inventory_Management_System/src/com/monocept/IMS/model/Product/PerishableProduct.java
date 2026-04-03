package com.monocept.IMS.model.Product;

public class PerishableProduct extends Product {
	private String expiryDate;
	public PerishableProduct(int id,String name,Double price,int stock,int threshold,String expiryDate ) {
		super(id,name,price,stock,threshold);
		this.expiryDate=expiryDate;
	}
	
	public String getExpiryDate() {
	    return expiryDate;
	}
	  @Override
	    public void showDetails() {
	        System.out.println(
	            getId() + "\t" +
	            getName() + "\t" +
	            getPrice() + "\t" +
	            getStock() + "\tPerishable\t" +
	            expiryDate
	        );
	    }

}
