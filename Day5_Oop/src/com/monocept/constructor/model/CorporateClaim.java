package com.monocept.constructor.model;

public class CorporateClaim extends InsuranceClaim {

    private static final double PROCESSING_FEE = 500;

    public CorporateClaim(String policyNumber, double claimAmount) {

        super(policyNumber, claimAmount); // must call parent first

        System.out.println("Processing Fee Applied: ₹" + PROCESSING_FEE);
    }
}