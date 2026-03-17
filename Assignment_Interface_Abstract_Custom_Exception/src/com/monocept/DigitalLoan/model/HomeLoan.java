package com.monocept.DigitalLoan.model;

public class HomeLoan extends Loan
{

    public HomeLoan(int loanId,String borrowerName,double principalAmount,double interestRate)
            throws InvalidLoanException
    {
        super(loanId,borrowerName,principalAmount,interestRate);
        System.out.println("HomeLoan constructor called");
    }

    @Override
    public double calculateRepayment()
    {
    	return getPrincipalAmount() + SystemConfig.processingFee+
                (getPrincipalAmount() * getinterestRate() / 100);
    }
}
