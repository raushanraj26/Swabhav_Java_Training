package com.monocept.OnlineOrderProcessing.model;

import java.util.Comparator;
public class OrderComparator implements Comparator<Order> {

    @Override
    public int compare(Order o1, Order o2) {

        // Priority first
        if (!o1.getType().equals(o2.getType())) {
            return o1.getType().equals("Priority") ? -1 : 1;
        }

        // Then amount descending
        return Double.compare(o2.getAmount(), o1.getAmount());
    }
}