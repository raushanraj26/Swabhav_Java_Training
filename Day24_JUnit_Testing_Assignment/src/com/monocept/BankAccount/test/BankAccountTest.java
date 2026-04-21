package com.monocept.BankAccount.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import com.monocept.BankAccount.model.Account;

public class BankAccountTest {
	 Account account;
	    
	    @ParameterizedTest
	    @CsvSource({
	        "1000, 500, 1500",
	        "1000, 200, 1200",
	        "1000, 0.5, 1000.5"
	    })
	    void shouldIncreaseBalanceWhenDepositIsValid(double initial, double amount, double expected) {
	        Account acc = new Account(initial);
	        acc.deposit(amount);
	        assertEquals(expected, acc.getBalance());
	    }
	    
	    @ParameterizedTest
	    @CsvSource({
	        "1000, 200, 800",
	        "1000, 500, 500",
	        "1000, 1000, 0"
	    })
	    void shouldDecreaseBalanceWhenWithdrawIsValid(double initial, double amount, double expected) {
	        Account acc = new Account(initial);
	        acc.withdraw(amount);
	        assertEquals(expected, acc.getBalance());
	    }
	    
	    @ParameterizedTest
	    @ValueSource(doubles = {-100.0, -1.0, -0.5})
	    void shouldThrowExceptionWhenDepositIsNegative(double amount) {
	        assertThrows(IllegalArgumentException.class, () -> {
	            account.deposit(amount);
	        });
	    }
	    
	    @ParameterizedTest
	    @ValueSource(doubles = {-50.0, -1.0})
	    void shouldThrowExceptionWhenWithdrawIsNegative(double amount) {
	        assertThrows(IllegalArgumentException.class, () -> {
	            account.withdraw(amount);
	        });
	    }
	    
	    @Test
	    void shouldThrowExceptionWhenWithdrawExceedsBalance() {
	        assertThrows(IllegalArgumentException.class, () -> {
	            account.withdraw(2000.0);
	        });
	    }
	    

	    @BeforeEach
	    @Disabled
	    void setup() {
	        account = new Account(1000.0); // initial balance
	    }

	   
	    @AfterEach
	    @Disabled
	    void tearDown() {
	        account = null;
	    }
	    
	    
	    @Test
	    @Disabled
	    void testDepositValid() {
	        account.deposit(500.0);
	        assertEquals(1500.0, account.getBalance());
	    }

	    @Test
	    @Disabled
	    void testWithdrawValid() {
	        account.withdraw(200.0);
	        assertEquals(800.0, account.getBalance());
	    }

	 
	    @Test
	    @Disabled
	    void testDepositNegative() {
	        assertThrows(IllegalArgumentException.class, () -> {
	            account.deposit(-100.0);
	        });
	    }


	    @Test
	    @Disabled
	    void testWithdrawNegative() {
	        assertThrows(IllegalArgumentException.class, () -> {
	            account.withdraw(-50.0);
	        });
	    }

	    @Test
	    @Disabled
	    void testWithdrawMoreThanBalance() {
	        assertThrows(IllegalArgumentException.class, () -> {
	            account.withdraw(2000.0);
	        });
	    }

	    // -------- Multiple Operations --------
	    @Test
	    @Disabled
	    void testBalanceAfterMultipleOperations() {
	        account.deposit(500.0);   // 1500
	        account.withdraw(300.0);  // 1200
	        assertEquals(1200.0, account.getBalance());
	    }

}
