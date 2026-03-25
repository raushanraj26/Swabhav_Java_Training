package com.monocept.CourseEnrollment.test;

import java.util.*;

import com.monocept.CourseEnrollment.model.*;

public class TestEnrollment {

    static Scanner sc = new Scanner(System.in);

   
    static Set<Participant> participants = new TreeSet<>();
    static Map<String, List<Participant>> batchMap = new HashMap<>();
    static Queue<Participant> waitingQueue = new LinkedList<>();

    public static void main(String[] args) {

        int choice;

        do {
            try {
                System.out.println("\n===== COURSE ENROLLMENT SYSTEM =====");
                System.out.println("1. Add Participant");
                System.out.println("2. Display All");
                System.out.println("3. Display Batch-wise");
                System.out.println("4. Sort by Name");
                System.out.println("5. Add to Waiting List");
                System.out.println("6. Process Waiting List");
                System.out.println("7. Remove by Track");
                System.out.println("8. Exit");

                System.out.print("Enter choice: ");
                choice = sc.nextInt();

                switch (choice) {

                    case 1:
                        addParticipant();
                        break;

                    case 2:
                        displayAll();
                        break;

                    case 3:
                        displayBatchWise();
                        break;

                    case 4:
                        sortByName();
                        break;

                    case 5:
                        addToWaiting();
                        break;

                    case 6:
                        processWaiting();
                        break;

                    case 7:
                        removeByTrack();
                        break;

                    case 8:
                        System.out.println("Exiting...");
                        break;

                    default:
                        System.out.println("Invalid choice!");
                }

            } catch (InputMismatchException e) {
                System.out.println("❌ Invalid input!");
                sc.nextLine();
                choice = 0;
            }

        } while (choice != 8);

        sc.close();
    }

    private static void addParticipant() {
        try {
            System.out.println("1. Regular");
            System.out.println("2. Corporate");
            int type = sc.nextInt();

            System.out.print("Enter ID: ");
            int id = sc.nextInt();
            if (id <= 0) throw new IllegalArgumentException("Invalid ID");

            sc.nextLine();

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            if (name.isEmpty())
                throw new IllegalArgumentException("Name cannot be empty");

            if (name.matches(".*\\d.*"))
                throw new IllegalArgumentException("Name cannot contain numbers!");

            System.out.print("Enter Track: ");
            String track = sc.nextLine();

            if (track.isEmpty())
                throw new IllegalArgumentException("Track cannot be empty");

            if (track.matches(".*\\d.*"))
                throw new IllegalArgumentException("Track cannot contain numbers!");

            Participant p = null;

            if (type == 1) {
                p = new RegularParticipant(id, name, track);
            } else if (type == 2) {
                System.out.print("Enter Company Name: ");
                String company = sc.nextLine();

                if (company.isEmpty())
                    throw new IllegalArgumentException("Company name required");

                p = new CorporateParticipant(id, name, track, company);
            } else {
                System.out.println("Invalid type!");
                return;
            }

            if (participants.add(p)) {
                batchMap.computeIfAbsent(track, k -> new ArrayList<>()).add(p);
                System.out.println("Participant added!");
            } else {
                System.out.println(" Duplicate not allowed!");
            }

        } catch (Exception e) {
            System.out.println(" Error: " + e.getMessage());
            sc.nextLine();
        }
    }

    // 🔷 DISPLAY ALL
    private static void displayAll() {
        if (participants.isEmpty()) {
            System.out.println("No participants found!");
            return;
        }

        for (Participant p : participants) {
            System.out.println(p);
        }
    }

    
    private static void displayBatchWise() {
        if (batchMap.isEmpty()) {
            System.out.println("No data!");
            return;
        }

        for (String track : batchMap.keySet()) {
            System.out.println("\nTrack: " + track);
            for (Participant p : batchMap.get(track)) {
                System.out.println(p);
            }
        }
    }


    private static void sortByName() {
        List<Participant> list = new ArrayList<>(participants);
        list.sort(new NameComparator());

        for (Participant p : list) {
            System.out.println(p);
        }
    }

    private static void addToWaiting() {
        try {
            System.out.print("Enter ID: ");
            int id = sc.nextInt();

            sc.nextLine();
            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            Participant p = new RegularParticipant(id, name, "Waiting");

            waitingQueue.add(p);

            System.out.println("Added to waiting list!");

        } catch (Exception e) {
            System.out.println("Error!");
            sc.nextLine();
        }
    }

    private static void processWaiting() {
        if (waitingQueue.isEmpty()) {
            System.out.println("No waiting participants!");
            return;
        }

        while (!waitingQueue.isEmpty()) {
            System.out.println("Processing: " + waitingQueue.poll());
        }
    }

    // REMOVE BY TRACK (Iterator safe removal)
    private static void removeByTrack() {
        sc.nextLine();
        System.out.print("Enter track: ");
        String track = sc.nextLine();

        Iterator<Participant> it = participants.iterator();

        while (it.hasNext()) {
            Participant p = it.next();
            if (p.getTrack().equalsIgnoreCase(track)) {
                it.remove();
            }
        }

        System.out.println(" Removed successfully!");
    }
}