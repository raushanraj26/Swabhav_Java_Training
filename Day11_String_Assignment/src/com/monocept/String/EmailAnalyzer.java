package com.monocept.String;

import java.util.Scanner;

public class EmailAnalyzer {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter an Email: ");
		String email = scanner.nextLine();

		while (!email.contains("@")) {
			System.out.print("Enter again Email: ");
			email = scanner.nextLine();

		}
		email = email.trim(); // removing spaces
		int position = email.indexOf("@");
		String username = email.substring(0, position);
		String domain = email.substring(position + 1);
		if (domain.equalsIgnoreCase("gmail.com")) {
			System.out.print("It belongs to gmail");

		} else {
			System.out.println("It does not belongs to gmail.");
		}
		email = email.toLowerCase();
		int count = username.length();

		boolean hasDigit = false;

		for (int i = 0; i < username.length(); i++) {
			char ch = username.charAt(i);

			if (Character.isDigit(ch)) {
				hasDigit = true;
				break;
			}
		}

		if (hasDigit) {
			System.out.println("Contains digits: Yes");
		} else {
			System.out.println("Contains digits: No");
		}
		String modifiedUsername = username.replace('.', '_');
		scanner.close();
	}

}
