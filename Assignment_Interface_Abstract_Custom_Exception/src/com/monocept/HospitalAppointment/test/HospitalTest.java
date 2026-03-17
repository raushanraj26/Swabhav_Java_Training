package com.monocept.HospitalAppointment.test;



import java.util.Scanner;
import com.monocept.HospitalAppointment.model.*;

public class HospitalTest {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Service service = null;   // polymorphic reference

        int choice;

        do {

            System.out.println("\n===== Hospital System =====");
            System.out.println("1. General Consultation");
            System.out.println("2. Surgery");
            System.out.println("3. Diagnostic Test");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            try {

                if(choice == 4) {
                    System.out.println("Exiting...");
                    break;
                }

                int id;

                while(true) {

                    System.out.print("Enter Service ID: ");

                    if(sc.hasNextInt()) {

                        id = sc.nextInt();

                        if(id > 0)
                            break;
                        else
                            System.out.println("ID must be positive");

                    } else {

                        System.out.println("Enter numeric ID only");
                        sc.next();
                    }
                };

                String name;

                while(true) {

                    sc.nextLine();
                    System.out.print("Enter Patient Name: ");
                    name = sc.nextLine();

                    if(name.matches("[a-zA-Z ]+") && !name.trim().isEmpty())
                        break;
                    else
                        System.out.println("Invalid name. Use alphabets only.");
                }

                double fee;

                while(true) {

                    System.out.print("Enter Consultation Fee: ");

                    if(sc.hasNextDouble()) {

                        fee = sc.nextDouble();

                        if(fee >= 0)
                            break;
                        else
                            System.out.println("Fee cannot be negative");

                    } else {

                        System.out.println("Enter numeric fee only");
                        sc.next();
                    }
                }

                switch(choice) {

                    case 1:
                        service = new GeneralConsultation(id, name, fee);
                        break;

                    case 2:
                        service = new Surgery(id, name, fee);
                        break;

                    case 3:
                        service = new DiagnosticTest(id, name, fee);
                        break;

                    default:
                        System.out.println("Invalid choice");
                        continue;
                }

                // Polymorphism
                if(service.validateService())
                    service.processService();
                else
                    System.out.println("Service validation failed");

            }
            catch(InvalidServiceException e) {
                System.out.println("Error: " + e.getMessage());
            }

        } while(true);

        sc.close();
    }
}