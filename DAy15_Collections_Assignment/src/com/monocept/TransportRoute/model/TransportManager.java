package com.monocept.TransportRoute.model;

import java.util.*;

public class TransportManager {

    Set<Passenger> passengerSet = new HashSet<>(); // avoid duplicates
    Map<Integer, List<Passenger>> routeMap = new HashMap<>();
    Queue<Passenger> waitingQueue = new LinkedList<>();

    // Register passenger
    public void addPassenger(Passenger p) {
        if (passengerSet.add(p)) {

            // Queue (waiting passengers)
            waitingQueue.add(p);

            // Route mapping
            routeMap
                .computeIfAbsent(p.routeNumber, k -> new ArrayList<>())
                .add(p);
            System.out.println("Addedd!");

        } else {
            System.out.println("Duplicate passenger not allowed: " + p.id);
        }
    }

    // Process boarding
    public void boardPassenger() {
        Passenger p = waitingQueue.poll();

        if (p != null) {
            System.out.println("Boarded: " + p);
        } else {
            System.out.println("No passengers waiting");
        }
    }

    // Display all
    public void displayAll() {
        for (Passenger p : passengerSet) {
            System.out.println(p);
        }
    }

    // Route-wise display
    public void displayByRoute(int route) {
        List<Passenger> list = routeMap.get(route);
        if (list != null) {
            for (Passenger p : list) {
                System.out.println(p);
            }
        } else {
            System.out.println("No passengers for this route");
        }
    }

    // Sort by route (natural)
    public void sortByRoute() {
        TreeSet<Passenger> sorted = new TreeSet<>(passengerSet);
        for (Passenger p : sorted) {
            System.out.println(p);
        }
    }

    // Sort by name
    public void sortByName() {
        List<Passenger> list = new ArrayList<>(passengerSet);
        list.sort(new SortByName());
        for (Passenger p : list) {
            System.out.println(p);
        }
    }

    // Remove passengers of a route (safe removal)
    public void removeByRoute(int route) {
        Iterator<Passenger> it = passengerSet.iterator();

        while (it.hasNext()) {
            Passenger p = it.next();
            if (p.routeNumber == route) {
                it.remove();
                System.out.println("Removed: " + p);
            }
        }
    }
}