package com.monocept.CountAssignment;
import java.util.*;

public class DiscountAndCount {
    public static void main(String[] args) {
        List<Double> prices = Arrays.asList(400.0, 800.0, 1000.0, 300.0, 700.0);

        long count = prices.stream()
                .map(p -> p * 0.8) // apply 20% discount
                .filter(p -> p > 500)
                .count();

        System.out.println("Products costing above 500 after discount: " + count);
    }
}
