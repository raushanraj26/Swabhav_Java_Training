package com.monocept.TransportRoute.model;

import java.util.Comparator;

public class SortByName implements Comparator<Passenger> {
    public int compare(Passenger p1, Passenger p2) {
        return p1.name.compareTo(p2.name);
    }
}