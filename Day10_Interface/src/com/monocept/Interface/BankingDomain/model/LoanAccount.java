package com.monocept.Interface.BankingDomain.model;

public class LoanAccount implements AccountOperation {

    private double loanBalance;

    public LoanAccount(double loanAmount) {
        this.loanBalance = loanAmount;
    }

    public void deposit(double amount) {
    	if(amount<=0) {
     	   System.out.println("Amount must be greater than 0.");
     	   return;
     	   
        }
        loanBalance -= amount;
        if (loanBalance < 0)
            loanBalance = 0;

        System.out.println("Loan repayment successful.");
    }

    public void withdraw(double amount) {
        loanBalance += amount;
        System.out.println("Loan amount increased.");
    }

    public void checkBalance() {
        System.out.println("Outstanding Loan Amount: " + loanBalance);
    }
}