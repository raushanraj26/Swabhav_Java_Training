package com.monocept.DigitalLoan.model;

public interface LoanEligibilityChecker
{
    boolean checkEligibility(Loan loan);
}
