package com.monocept.String;

import java.util.Scanner;

public class PasswordValidator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter password: ");
        String password = sc.nextLine();

        
        boolean lengthValid = password.length() >= 8;

        
        boolean hasUppercase = false;
        boolean hasLowercase = false;
        boolean hasDigit = false;

      
        for(int i = 0; i < password.length(); i++) {

            char ch = password.charAt(i);

            
            if(Character.isUpperCase(ch)) {
                hasUppercase = true;
            }

          
            if(Character.isLowerCase(ch)) {
                hasLowercase = true;
            }

            
            if(Character.isDigit(ch)) {
                hasDigit = true;
            }
        }

        String modifiedPassword = password.replace(" ", "");

       
        System.out.println("Length valid: " + (lengthValid ? "Yes" : "No"));
        System.out.println("Contains uppercase: " + (hasUppercase ? "Yes" : "No"));
        System.out.println("Contains lowercase: " + (hasLowercase ? "Yes" : "No"));
        System.out.println("Contains digit: " + (hasDigit ? "Yes" : "No"));

        
        if(lengthValid && hasUppercase && hasLowercase && hasDigit) {
            System.out.println("Password is VALID");
        } else {
            System.out.println("Password is INVALID");
        }

        sc.close();
    }
}
