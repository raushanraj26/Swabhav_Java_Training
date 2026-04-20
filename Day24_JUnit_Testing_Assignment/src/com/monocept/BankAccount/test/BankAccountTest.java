package com.monocept.BankAccount.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.monocept.BankAccount.model.Account;

public class BankAccountTest {
	 Account account;

	   
	    @BeforeEach
	    void setup() {
	        account = new Account(1000.0); // initial balance
	    }

	   
	    @AfterEach
	    void tearDown() {
	        account = null;
	    }

	    @Test
	    void testDepositValid() {
	        account.deposit(500.0);
	        assertEquals(1500.0, account.getBalance());
	    }

	    @Test
	    void testWithdrawValid() {
	        account.withdraw(200.0);
	        assertEquals(800.0, account.getBalance());
	    }

	 
	    @Test
	    void testDepositNegative() {
	        assertThrows(IllegalArgumentException.class, () -> {
	            account.deposit(-100.0);
	        });
	    }


	    @Test
	    void testWithdrawNegative() {
	        assertThrows(IllegalArgumentException.class, () -> {
	            account.withdraw(-50.0);
	        });
	    }

	    @Test
	    void testWithdrawMoreThanBalance() {
	        assertThrows(IllegalArgumentException.class, () -> {
	            account.withdraw(2000.0);
	        });
	    }

	    // -------- Multiple Operations --------
	    @Test
	    void testBalanceAfterMultipleOperations() {
	        account.deposit(500.0);   // 1500
	        account.withdraw(300.0);  // 1200
	        assertEquals(1200.0, account.getBalance());
	    }

}
