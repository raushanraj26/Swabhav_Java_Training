package com.monocept.IMS.model.Product;

 public class Product {
	private int id;
	private String name;
	private int stock;
	private Double price;
	private int threshold;
	public Product(int id,String name,Double price,int stock,int threshold) {
		this.id=id;
		this.name=name;
		this.price=price;
		this.stock=stock;
		this.threshold=threshold;
	}
	
	public int getId() {
	    return id;
	}

	public String getName() {
	    return name;
	}

	public int getStock() {
	    return stock;
	}

	public Double getPrice() {
	    return price;
	}
	public int getThreshold() {
	    return threshold;
	}
	public void setStock(int stock) {
		  if (stock < 0) {
		        System.out.println("Stock cannot be negative");
		        return;
		    }
	    this.stock = stock;
	} 
}
