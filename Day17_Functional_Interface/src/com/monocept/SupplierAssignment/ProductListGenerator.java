package com.monocept.SupplierAssignment;
import java.util.*;
import java.util.function.Supplier;

public class ProductListGenerator {

    public static void main(String[] args) {

        
        Supplier<List<String>> productSupplier = () -> {
            List<String> products = new ArrayList<>();
            products.add("Phone");
            products.add("Laptop");
            products.add("Tablet");
            products.add("Watch");
            products.add("Camera");
            return products;
        };

        List<String> productList = productSupplier.get();
        for(String product : productList) {
            System.out.println(product);
        }
    }
}
