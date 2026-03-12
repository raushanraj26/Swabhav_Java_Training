package com.monocept.Interface.Vehicle.model;

public class Truck implements VehicleControl {

    private int gear;

    public void start() {
        System.out.println("Truck started with heavy engine.");
    }

    public void stop() {
        System.out.println("Truck stopped.");
    }

    public void changeGear(int gear) {

        if (gear >= 1 && gear <= 6) {
            this.gear = gear;
            System.out.println("Truck gear changed to: " + gear);
        } else {
            System.out.println("Invalid gear! Truck supports only 1 to 6.");
        }
    }
}