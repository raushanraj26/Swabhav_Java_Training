package com.monocept.OnlineOrderProcessing.model;
import java.util.Comparator;

public class PriorityComparator implements Comparator<Order> {

    @Override
    public int compare(Order o1, Order o2) {

        if (!o1.getType().equals(o2.getType())) {
            return o1.getType().equals("Priority") ? -1 : 1;
        }
        return 0;
    }
}