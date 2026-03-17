package com.monocept.DigitalLoan.model;

public class EducationLoan extends Loan
{

    public EducationLoan(int loanId,String borrowerName,double principalAmount,double interestRate)
            throws InvalidLoanException
    {
        super(loanId,borrowerName,principalAmount,interestRate);
        System.out.println("EducationLoan constructor called");
    }

    @Override
    public double calculateRepayment()
    {
    	return getPrincipalAmount() + SystemConfig.processingFee+
                (getPrincipalAmount() * getinterestRate() / 100);
    }

}