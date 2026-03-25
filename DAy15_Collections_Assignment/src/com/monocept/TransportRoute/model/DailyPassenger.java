package com.monocept.TransportRoute.model;

public class DailyPassenger extends Passenger {

    public DailyPassenger(int id, String name, int routeNumber) {
        super(id, name, routeNumber);
    }

    @Override
    public String getType() {
        return "Daily";
    }
}
