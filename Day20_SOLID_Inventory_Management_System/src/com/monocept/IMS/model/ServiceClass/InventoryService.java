package com.monocept.IMS.model.ServiceClass;

import com.monocept.IMS.model.Product.*;

import java.util.ArrayList;
import java.util.List;

public class InventoryService {
	private List<Product> products;
	
	public InventoryService() {
		products = new ArrayList<>();
	}

	public void addProduct(Product p) {
		products.add(p);
	}

	public void addStock(Product p, int qty) {
		if (!products.contains(p)) {
			System.out.println("This Product is not available");
			return;
			
		}
		if (qty <= 0) {
			System.out.println("Quantity must be Positive!");
			return;
		}
		p.setStock(p.getStock()+qty);

	}

	public void removeStock(Product p, int qty) {
		if (!products.contains(p)) {
			System.out.println("This Product is not available");
			return;
			
		}

		if(qty<=0) {
			System.out.println("Quantity must be Positive!");
			return;
			
		}
		if(p.getStock()<qty) {
			System.out.println("Less Stock! cannot remove");
			return;
			
			
		}
		p.setStock(p.getStock()-qty);
	}

}
