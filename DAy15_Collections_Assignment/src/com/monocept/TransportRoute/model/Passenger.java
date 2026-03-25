package com.monocept.TransportRoute.model;

import java.util.*;

public abstract class Passenger implements Comparable<Passenger> {
    int id;
    String name;
    int routeNumber;

    public Passenger(int id, String name, int routeNumber) {
        this.id = id;
        this.name = name;
        this.routeNumber = routeNumber;
    }

    public abstract String getType();

    // Natural sorting → by route number
    @Override
    public int compareTo(Passenger p) {
        return this.routeNumber - p.routeNumber;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Passenger)) return false;
        Passenger p = (Passenger) obj;
        return this.id == p.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return id + " " + name + " Route:" + routeNumber + " Type:" + getType();
    }
}
