package com.monocept.EcxeptionHandling;

import java.util.Scanner;

public class FinallyBlockEx {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double balance = 1000;
		try {
			System.out.print("Enter amount to withdraw:");
			double amount = sc.nextDouble();
			if (amount <= 0) {
				throw new IllegalArgumentException("Amount must be positive");
			}

			if (amount > balance) {
				throw new ArithmeticException("Insufficient balance");
			}

			balance = balance - amount;
			System.out.println("Withdrawal successful");
			System.out.println("Remaining balance: " + balance);
		} catch (IllegalArgumentException e) {
			System.out.println("Error: " + e.getMessage()); // message me jo khud bnaaye hai wo show hoga
		} catch (ArithmeticException e) {
			System.out.println("Error: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Exception Type: " + e.getClass().getSimpleName());
			System.out.println("Error: " + e.getMessage());
		} finally {
			System.out.println("Transaction session ended.");
		}
	}

}
