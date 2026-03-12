package com.monocept.ArrayofObj.model;

public class RegularCourse extends Course {

    private double labFee;

    public RegularCourse(String id, String name, double fee, double labFee) {
        super(id, name, fee);
        this.labFee = labFee;
    }

    @Override
    public double calculateFee() {
        return baseFee + labFee;
    }
}
