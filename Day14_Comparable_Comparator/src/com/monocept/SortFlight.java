package com.monocept;

import java.util.*;

public class SortFlight {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List<Flight> flights = new ArrayList<>();

       
        int n = 0;

        // ✅ Validate number of flights
        while (true) {
            System.out.print("Enter number of flights: ");

            if (sc.hasNextInt()) {
                n = sc.nextInt();
                sc.nextLine();

                if (n > 0) {
                    break;
                } else {
                    System.out.println("Number must be greater than 0!");
                }
            } else {
                System.out.println("Invalid input! Enter a number.");
                sc.nextLine();
            }
        }


        for(int i = 0; i < n; i++) {

            System.out.println("\nEnter flight details " + (i+1));

         // ✅ Validate Airline Name
            String airline;
            while (true) {
                System.out.print("Enter airline name: ");
                airline = sc.nextLine();

                if (airline.matches("[a-zA-Z ]+") && !airline.trim().isEmpty()) {
                    break;
                } else {
                    System.out.println("Invalid name! Only letters allowed.");
                }
            }


            // ✅ Validate Fare
            double fare;
            while (true) {
                System.out.print("Enter fare: ");

                if (sc.hasNextDouble()) {
                    fare = sc.nextDouble();
                    sc.nextLine();

                    if (fare > 0) {
                        break;
                    } else {
                        System.out.println("Fare must be greater than 0!");
                    }
                } else {
                    System.out.println("Invalid input! Enter a valid number.");
                    sc.nextLine();
                }
            }

            flights.add(new Flight(airline, fare));
        }

        // Sorting flights by fare (descending)
        Collections.sort(flights, new FlightComparator());

        System.out.println("\nFlights sorted by Fare (Descending):");

        for(Flight f : flights) {
            System.out.println(f);
        }

        sc.close();
    }
}


class Flight {

    private String airline;
    private double fare;

    public Flight(String airline, double fare) {
        this.airline = airline;
        this.fare = fare;
    }

    public String getAirline() {
        return airline;
    }

    public double getFare() {
        return fare;
    }

    public String toString() {
        return airline + " - " + fare;
    }
}


class FlightComparator implements Comparator<Flight> {

    public int compare(Flight f1, Flight f2) {

        // descending order
        return Double.compare(f2.getFare(), f1.getFare());
    }
}