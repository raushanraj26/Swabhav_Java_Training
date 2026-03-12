package com.monocept.Interface.Vehicle.model;

public class Car implements VehicleControl {

    private int gear;

    public void start() {
        System.out.println("Car started with key ignition.");
    }

    public void stop() {
        System.out.println("Car stopped.");
    }

    public void changeGear(int gear) {

        if (gear >= 1 && gear <= 5) {
            this.gear = gear;
            System.out.println("Car gear changed to: " + gear);
        } else {
            System.out.println("Invalid gear! Car supports only 1 to 5.");
        }
    }
}