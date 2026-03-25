package com.monocept.LibraryBook.test;

import java.util.*;
import com.monocept.LibraryBook.model.*;

public class LibrayBookMangaement {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        TreeSet<Book> books = new TreeSet<>(new BookTitleComparator());
        Queue<String> peopleQueue = new LinkedList<>();

        int mainChoice = 0;

        do {
            try {
                System.out.println("\n------- MAIN MENU ----");
                System.out.println("1. Add Person to Queue");
                System.out.println("2. Process Queue");
                System.out.println("3. Exit");

                System.out.print("Enter choice: ");
                mainChoice = sc.nextInt();
                sc.nextLine();

                switch (mainChoice) {

                case 1:
                    System.out.print("Enter person name: ");
                    String name = sc.nextLine();

                    if (name.isEmpty() || name.matches(".*\\d.*")) {
                        throw new IllegalArgumentException("Invalid name!");
                    }

                    peopleQueue.add(name);
                    System.out.println(name + " added to queue");
                    break;

                case 2:

                    if (peopleQueue.isEmpty()) {
                        System.out.println("Queue is empty");
                        break;
                    }

                    String person = peopleQueue.peek();
                    System.out.println("\nNow serving: " + person);

                    int subChoice = 0;

                    do {
                        try {
                            System.out.println("\n--- BOOK MENU ---");
                            System.out.println("1. Add Book");
                            System.out.println("2. Remove Book");
                            System.out.println("3. Display Books");
                            System.out.println("4. Done (Next Person)");

                            System.out.print("Enter choice: ");
                            subChoice = sc.nextInt();
                            sc.nextLine();

                            switch (subChoice) {

                            case 1:
                                System.out.println("Select Book Type:");
                                System.out.println("1. Academic Book");
                                System.out.println("2. Magazine Book");

                                int type = sc.nextInt();
                                sc.nextLine();

                                if (type != 1 && type != 2) {
                                    throw new IllegalArgumentException("Invalid type!");
                                }

                                System.out.print("Enter ID: ");
                                int id = sc.nextInt();
                                if (id <= 0)
                                    throw new IllegalArgumentException("ID must be positive");
                                sc.nextLine();

                                System.out.print("Enter Title: ");
                                String title = sc.nextLine();
                                if (title.isEmpty())
                                    throw new IllegalArgumentException("Title required");

                                System.out.print("Enter Author: ");
                                String author = sc.nextLine();
                                if (author.isEmpty())
                                    throw new IllegalArgumentException("Author required");

                                if (type == 1) {
                                    System.out.print("Enter Subject: ");
                                    String subject = sc.nextLine();
                                    if (subject.isEmpty())
                                        throw new IllegalArgumentException("Subject required");

                                    System.out.print("Enter Edition: ");
                                    int edition = sc.nextInt();
                                    if (edition <= 0)
                                        throw new IllegalArgumentException("Edition must be positive");

                                    books.add(new AcademicBook(id, title, author, subject, edition));
                                    System.out.println("✅ Academic Book Added");

                                } else {
                                    try {
                                        System.out.print("Enter Month (JAN, FEB, ...): ");
                                        String m = sc.nextLine().toUpperCase();

                                        Month month = Month.valueOf(m);

                                        books.add(new MegazineBook(id, title, author, month));
                                        System.out.println(" Magazine Book Added");

                                    } catch (Exception e) {
                                        System.out.println(" Invalid month!");
                                    }
                                }
                                break;

                            case 2:
                                System.out.print("Enter ID to remove: ");
                                int removeId = sc.nextInt();

                                boolean removed = books.removeIf(b -> b.getId() == removeId);

                                if (removed)
                                    System.out.println("Book removed");
                                else
                                    System.out.println(" Book not found");

                                break;

                            case 3:
                                if (books.isEmpty()) {
                                    System.out.println("No books available");
                                } else {
                                    for (Book b : books) {
                                        System.out.println(b);
                                    }
                                }
                                break;

                            case 4:
                                System.out.println("Moving to next person...");
                                break;

                            default:
                                System.out.println("Invalid choice!");
                            }

                        } catch (InputMismatchException e) {
                            System.out.println(" Invalid input type!");
                            sc.nextLine();
                        } catch (IllegalArgumentException e) {
                            System.out.println( e.getMessage());
                        }

                    } while (subChoice != 4);

                    peopleQueue.poll();
                    System.out.println(person + " processed and removed from queue");
                    break;

                case 3:
                    System.out.println("Exit");
                    break;

                default:
                    System.out.println("Invalid choice!");
                }

            } catch (InputMismatchException e) {
                System.out.println("❌ Please enter correct numeric value!");
                sc.nextLine();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

        } while (mainChoice != 3);

        sc.close();
    }
}