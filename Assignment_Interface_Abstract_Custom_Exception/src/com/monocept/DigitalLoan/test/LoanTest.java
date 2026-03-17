package com.monocept.DigitalLoan.test;

import java.util.Scanner;
import com.monocept.DigitalLoan.model.*;

public class LoanTest {
	 public static void main(String[] args) {

	        Scanner sc = new Scanner(System.in);

	        Loan[] loans = new Loan[10];
	        int count = 0;

	        LoanEligibilityChecker checker = new LoanEligibilityService();

	        int choice;

	        do {

	            System.out.println("\n====== DIGITAL LOAN SYSTEM ======");
	            System.out.println("1. Create Home Loan");
	            System.out.println("2. Create Car Loan");
	            System.out.println("3. Create Education Loan");
	            System.out.println("4. Process Loans");
	            System.out.println("5. Exit");

	            System.out.print("Enter choice: ");

	            while(!sc.hasNextInt()) {
	                System.out.print("Enter number only: ");
	                sc.next();
	            }

	            choice = sc.nextInt();

	            try {

	                switch(choice) {

	                case 1:

	                	System.out.print("Enter Loan ID: ");

	                	while(!sc.hasNextInt())
	                	{
	                	    System.out.print("Invalid Loan ID. Enter numeric value: ");
	                	    sc.next(); 
	                	}

	                	int id1 = sc.nextInt();
	                    sc.nextLine();
	                    System.out.print("Enter Borrower Name: ");
	                    String name1 = sc.nextLine();

	                    System.out.print("Enter Principal Amount: ");
	                    double amount1 = sc.nextDouble();

	                    System.out.print("Enter Interest Rate: ");
	                    double rate1 = sc.nextDouble();

	                    loans[count++] = new HomeLoan(id1,name1,amount1,rate1);

	                    System.out.println("Home Loan Created");
	                    break;



	                case 2:

	                	System.out.print("Enter Loan ID: ");

	                	while(!sc.hasNextInt())
	                	{
	                	    System.out.print("Invalid Loan ID. Enter numeric value: ");
	                	    sc.next(); 
	                	}

	                	int id2 = sc.nextInt();

	                    sc.nextLine();
	                    System.out.print("Enter Borrower Name: ");
	                    String name2 = sc.nextLine();

	                    System.out.print("Enter Principal Amount: ");
	                    double amount2 = sc.nextDouble();

	                    System.out.print("Enter Interest Rate: ");
	                    double rate2 = sc.nextDouble();

	                    loans[count++] = new CarLoan(id2,name2,amount2,rate2);

	                    System.out.println("Car Loan Created");
	                    break;



	                case 3:

	                	System.out.print("Enter Loan ID: ");

	                	while(!sc.hasNextInt())
	                	{
	                	    System.out.print("Invalid Loan ID. Enter numeric value: ");
	                	    sc.next(); 
	                	}

	                	int id3 = sc.nextInt();

	                    sc.nextLine();
	                    System.out.print("Enter Borrower Name: ");
	                    String name3 = sc.nextLine();

	                    System.out.print("Enter Principal Amount: ");
	                    double amount3 = sc.nextDouble();

	                    System.out.print("Enter Interest Rate: ");
	                    double rate3 = sc.nextDouble();

	                    loans[count++] = new EducationLoan(id3,name3,amount3,rate3);

	                    System.out.println("Education Loan Created");
	                    break;



	                case 4:

	                    if(count == 0) {
	                        System.out.println("No loans available");
	                        break;
	                    }

	                    for(int i=0;i<count;i++) {

	                        Loan loan = loans[i];

	                        System.out.println("\nBorrower: "+loan.getborrowerName());

	                        if(checker.checkEligibility(loan)) {

	                            double repayment = loan.calculateRepayment();

	                            System.out.println("Repayment Amount: "+repayment);

	                        }
	                        else {
	                            System.out.println("Loan not eligible");
	                        }
	                    }

	                    break;



	                case 5:
	                    System.out.println("Exiting system...");
	                    break;



	                default:
	                    System.out.println("Invalid choice");

	                }

	            }

	            catch(InvalidLoanException e) {

	                System.out.println("Error: "+e.getMessage());

	            }

	        } while(choice != 5);

	        sc.close();
	    }

}
