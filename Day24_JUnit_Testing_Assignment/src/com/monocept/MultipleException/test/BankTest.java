package com.monocept.MultipleException.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.monocept.MultipleException.model.BankService;

public class BankTest {
	 // amount <= 0
    @Test
    void testWithdrawAmountZeroOrNegative() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            BankService.withdraw(1000, 0);
        });

        assertEquals("Amount must be greater than 0", exception.getMessage());
    }

    // amount > balance
    @Test
    void testWithdrawMoreThanBalance() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            BankService.withdraw(1000, 1500);
        });

        assertEquals("Insufficient balance", exception.getMessage());
    }

    //  valid withdrawal
    @Test
    void testWithdrawSuccess() {
        double result = BankService.withdraw(1000, 200);
        assertEquals(800, result);
    }

}
