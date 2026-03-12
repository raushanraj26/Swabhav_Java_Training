package com.monocept.stream;



import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        FileService service = new FileService();

        while(true) {

            System.out.println("\n1 Create");
            System.out.println("2 Read");
            System.out.println("3 Update");
            System.out.println("4 Delete");
            System.out.println("5 Exit");

            System.out.print("Choose option: ");
            int choice = sc.nextInt();

            switch(choice) {

                case 1:
                    service.createRecord();
                    break;

                case 2:
                    service.readRecords();
                    break;

                case 3:
                    service.updateRecord();
                    break;

                case 4:
                    service.deleteRecord();
                    break;

                case 5:
                    System.out.println("Exit");
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}