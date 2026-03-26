package com.monocept.SupplierAssignment;
import java.util.Scanner;
import java.util.function.Supplier;

public class DefaultCityProvider {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Supplier<String> defaultCity = () -> "Pune";
        System.out.print("Enter city: ");
        String userInput = sc.nextLine();
        String city = (userInput == null || userInput.isEmpty())
                      ? defaultCity.get()
                      : userInput;

        System.out.println("Selected City: " + city);

        sc.close();
    }
}