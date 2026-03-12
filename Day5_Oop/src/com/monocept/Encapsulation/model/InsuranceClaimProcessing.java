package com.monocept.Encapsulation.model;



enum ClaimStatus {
    FILED,
    APPROVED,
    REJECTED,
    SETTLED
}


public class InsuranceClaimProcessing {
	private final int claimId;        // immutable
    private String policyNumber;
    private double claimAmount;
    private double approvedAmount;
    private ClaimStatus claimStatus;

    // Constructor
    public InsuranceClaimProcessing(int claimId, String policyNumber, double claimAmount) {

        if (claimAmount < 0) {
            System.out.println("Claim amount cannot be negative.");
            claimAmount = 0;
        }

        this.claimId = claimId;
        this.policyNumber = policyNumber;
        this.claimAmount = claimAmount;
        this.claimStatus = ClaimStatus.FILED;  // default status
    }

    // Getter methods
    public int getClaimId() {
        return claimId;
    }

    public ClaimStatus getClaimStatus() {
        return claimStatus;
    }

    public void showDetails() {
        System.out.println("\nClaim ID: " + claimId);
        System.out.println("Policy Number: " + policyNumber);
        System.out.println("Claim Amount: " + claimAmount);
        System.out.println("Approved Amount: " + approvedAmount);
        System.out.println("Status: " + claimStatus);
    }

    // Approve Claim
    public void approveClaim(double amount) {

        if (claimStatus != ClaimStatus.FILED) {
            System.out.println("Claim can only be approved if it is FILED.");
            return;
        }

        if (amount > claimAmount) {
            System.out.println("Approved amount cannot exceed claim amount.");
            return;
        }

        approvedAmount = amount;
        claimStatus = ClaimStatus.APPROVED;
        System.out.println("Claim Approved Successfully.");
    }

    // Reject Claim
    public void rejectClaim() {

        if (claimStatus != ClaimStatus.FILED) {
            System.out.println("Claim can only be rejected if it is FILED.");
            return;
        }

        claimStatus = ClaimStatus.REJECTED;
        System.out.println("Claim Rejected.");
    }

    // Settle Claim
    public void settleClaim() {

        if (claimStatus != ClaimStatus.APPROVED) {
            System.out.println("Only APPROVED claim can be settled.");
            return;
        }

        claimStatus = ClaimStatus.SETTLED;
        System.out.println("Claim Settled Successfully.");
    }
	

}
