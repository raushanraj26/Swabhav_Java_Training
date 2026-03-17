package com.monocept.DigitalLoan.model;

public class CarLoan extends Loan
{

    public CarLoan(int loanId,String borrowerName,double principalAmount,double interestRate)
            throws InvalidLoanException
    {
        super(loanId,borrowerName,principalAmount,interestRate);
        System.out.println("CarLoan constructor called");
    }

    @Override
    public double calculateRepayment()
    {
    	return getPrincipalAmount() + SystemConfig.processingFee+
                (getPrincipalAmount() * getinterestRate() / 100);
    }
}