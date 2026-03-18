package com.monocept.OnlineOrderProcessing.model;
import java.util.Comparator;

public class AmountComparator implements Comparator<Order> {

    @Override
    public int compare(Order o1, Order o2) {
        return Double.compare(o2.getAmount(), o1.getAmount());
    }
}