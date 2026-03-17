package com.monocept.DigitalLoan.model;

public class LoanEligibilityService implements LoanEligibilityChecker
{
    @Override
    public boolean checkEligibility(Loan loan)
    {
        if(loan.getPrincipalAmount() > 1000)
        {
            return true;
        }
        return false;
    }
}