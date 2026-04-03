package com.monocept.IMS.model.Product;

public class NonPerishableProduct extends Product {
	public NonPerishableProduct(int id,String name,Double price,int stock,int threshold) {
		super(id,name,price,stock,threshold);
		
	}
	@Override
    public void showDetails() {
        System.out.println(
            getId() + "\t" +
            getName() + "\t" +
            getPrice() + "\t" +
            getStock() + "\tNon-Perishable\t-"
        );
    }
}
