package com.monocept.TransportRoute.model;

public class TouristPassenger extends Passenger {

    public TouristPassenger(int id, String name, int routeNumber) {
        super(id, name, routeNumber);
    }

    @Override
    public String getType() {
        return "Tourist";
    }
}
