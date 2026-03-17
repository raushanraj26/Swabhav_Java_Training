package com.monocept.DigitalLoan.model;

public abstract class Loan
{
    private int loanId;
    private String borrowerName;
    private double principalAmount;
   private double interestRate;

    static
    {
        System.out.println("Loan class loaded");
    }

    public Loan(int loanId,String borrowerName,double principalAmount,double interestRate)
            throws InvalidLoanException
    {
        if(principalAmount <= 0)
        {
            throw new InvalidLoanException("Principal amount cannot be negative");
        }

        if(interestRate <= 0)
        {
            throw new InvalidLoanException("Interest rate must be positive");
        }

        this.loanId = loanId;
        this.borrowerName = borrowerName;
        this.principalAmount = principalAmount;
        this.interestRate = interestRate;

        System.out.println("Loan constructor executed");
    }

    public double getPrincipalAmount()
    {
        return principalAmount;
    }
    public double getinterestRate()
    {
        return interestRate;
    }
   
    public String getborrowerName()
    {
        return borrowerName;
    }

    public abstract double calculateRepayment();
}
