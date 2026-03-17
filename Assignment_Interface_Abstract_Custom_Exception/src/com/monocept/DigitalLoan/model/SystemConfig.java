package com.monocept.DigitalLoan.model;

public class SystemConfig
{
    public static double processingFee;

    static
    {
        processingFee = 50;
        System.out.println("System configuration loaded");
    }
}
