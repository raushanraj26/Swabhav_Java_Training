package com.monocept.Interface.Vehicle.model;

public class Bike implements VehicleControl {

    private int gear;

    public void start() {
        System.out.println("Bike started with self-start.");
    }

    public void stop() {
        System.out.println("Bike stopped.");
    }

    public void changeGear(int gear) {

        if (gear >= 1 && gear <= 4) {
            this.gear = gear;
            System.out.println("Bike gear changed to: " + gear);
        } else {
            System.out.println("Invalid gear! Bike supports only 1 to 4.");
        }
    }
}
