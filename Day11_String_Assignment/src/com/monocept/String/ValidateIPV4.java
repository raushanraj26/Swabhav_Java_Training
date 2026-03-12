package com.monocept.String;

import java.util.Scanner;

public class ValidateIPV4 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter IP Address: ");
        String ip = sc.nextLine();

        String[] parts = ip.split("\\.");

        if(parts.length != 4) {
            System.out.println("Invalid IP Address");
            return;
        }

        for(int i = 0; i < parts.length; i++) {

            String part = parts[i];

            if(part.length() == 0) {
                System.out.println("Invalid IP Address");
                return;
            }

            for(int j = 0; j < part.length(); j++) {

                if(!Character.isDigit(part.charAt(j))) {
                    System.out.println("Invalid IP Address");
                    return;
                }
            }

            int num = Integer.parseInt(part);

            if(num < 0 || num > 255) {
                System.out.println("Invalid IP Address");
                return;
            }
        }

        System.out.println("Valid IP Address");
    }

}
