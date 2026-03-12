package com.monocept.Encapsulation.test;
import java.util.Scanner;
import com.monocept.Encapsulation.model.InsuranceClaimProcessing;
public class InsuranceClaimProcessingTest {
	public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Claim ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter Policy Number: ");
        String policy = sc.nextLine();

        System.out.println("Enter Claim Amount: ");
        double amount = sc.nextDouble();

        InsuranceClaimProcessing claim = new InsuranceClaimProcessing(id, policy, amount);

        int choice;

        do {
            System.out.println("\n--- Insurance Claim Menu ---");
            System.out.println("1. Show Claim Details");
            System.out.println("2. Approve Claim");
            System.out.println("3. Reject Claim");
            System.out.println("4. Settle Claim");
            System.out.println("5. Exit");
            System.out.println("Enter your choice:");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    claim.showDetails();
                    break;

                case 2:
                    System.out.println("Enter Approved Amount:");
                    double approvedAmt = sc.nextDouble();
                    claim.approveClaim(approvedAmt);
                    break;

                case 3:
                    claim.rejectClaim();
                    break;

                case 4:
                    claim.settleClaim();
                    break;

                case 5:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);

        sc.close();
    }

}
