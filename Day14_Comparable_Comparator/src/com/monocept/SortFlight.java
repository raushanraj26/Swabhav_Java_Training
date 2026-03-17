package com.monocept;

import java.util.*;

public class SortFlight {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List<Flight> flights = new ArrayList<>();

        System.out.print("Enter number of flights: ");
        int n = sc.nextInt();
        sc.nextLine();

        for(int i = 0; i < n; i++) {

            System.out.println("\nEnter flight details " + (i+1));

            System.out.print("Enter airline name: ");
            String airline = sc.nextLine();

            System.out.print("Enter fare: ");
            double fare = sc.nextDouble();
            sc.nextLine();

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