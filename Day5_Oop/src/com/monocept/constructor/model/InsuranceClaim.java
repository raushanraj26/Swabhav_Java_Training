package com.monocept.constructor.model;

public class InsuranceClaim {

    private static int counter = 1000;  // auto id generator

    private final int claimId;
    private String policyNumber;
    private double claimAmount;
    private String status;
    protected double approvedAmount;

    // Parameterized Constructor
    public InsuranceClaim(String policyNumber, double claimAmount) {

        this.claimId = ++counter;  // auto generated
        this.policyNumber = policyNumber;

        if (claimAmount < 0) {
            System.out.println("Claim amount cannot be negative. Setting to 0.");
            this.claimAmount = 0;
        } else {
            this.claimAmount = claimAmount;
        }

        this.status = "Filed";   // always starts as Filed
        this.approvedAmount = 0; // initially 0
    }

    public void displayClaim() {
        System.out.println("Claim ID: " + claimId);
        System.out.println("Policy Number: " + policyNumber);
        System.out.println("Claim Amount: " + claimAmount);
        System.out.println("Status: " + status);
        System.out.println("Approved Amount: " + approvedAmount);
    }
}