package com.monocept.DigitalLoan.model;

public class InvalidLoanException extends Exception
{
	private static final long serialVersionUID = 1L;

    public InvalidLoanException(String message)
    {
        super(message);
    }
}