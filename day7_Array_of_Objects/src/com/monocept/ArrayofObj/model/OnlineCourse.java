package com.monocept.ArrayofObj.model;

public class OnlineCourse extends Course {

    private double platformFee;

    public OnlineCourse(String id, String name, double fee, double platformFee) {
        super(id, name, fee);
        this.platformFee = platformFee;
    }

    @Override
    public double calculateFee() {
        return baseFee + platformFee;
    }
}