package com.monocept.OnlineOrderProcessing.test;



import java.util.*;

import com.monocept.OnlineOrderProcessing.model.*;


public class OrderTest {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Queue<Order> queue = new LinkedList<>();
        Set<Integer> orderIds = new HashSet<>();
        Map<String, List<Order>> customerMap = new HashMap<>();
        List<Order> allOrders = new ArrayList<>();

        int choice;

        do {
            System.out.println("\n-------- Order System -----------");
            System.out.println("1. Add Order");
            System.out.println("2. Process Order");
            System.out.println("3. View Orders");
            System.out.println("4. Remove Invalid Orders");
            System.out.println("5. View Customer Orders");
            System.out.println("0. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {

                //add order
                case 1:
                    System.out.println("Choose Type: 1.Regular  2.Priority");
                    int type = sc.nextInt();

                    System.out.print("Enter Order ID: ");
                    int id = sc.nextInt();

                    if (orderIds.contains(id)) {//check already present 
                        System.out.println(" Duplicate ID!");
                        break;
                    }

                    sc.nextLine();

                    System.out.print("Enter Customer Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Amount: ");
                    double amount = sc.nextDouble();

                    Order order;

                    if (type == 1) {
                        order = new RegularOrder(id, name, amount);
                    } else {
                        order = new PriorityOrder(id, name, amount);
                    }

                    queue.add(order);
                    orderIds.add(id);
                    allOrders.add(order);

                    customerMap.putIfAbsent(name, new ArrayList<>());
                    customerMap.get(name).add(order);

                    System.out.println("Order added!");
                    break;

                //processing order,queue
                case 2:
                    if (queue.isEmpty()) {
                        System.out.println("No orders to process");
                    } else {
                        Order processed = queue.poll();
                        System.out.println("Processing: " + processed);
                    }
                    break;

                // view & sort using comparator c;lasss
                case 3:
                    if (allOrders.isEmpty()) {
                        System.out.println("No orders available.");
                        break;
                    }

                    System.out.println("Choose Sorting:");
                    System.out.println("1. Amount High → Low");
                    System.out.println("2. Customer Name");
                    System.out.println("3. Priority First");

                    int sortChoice = sc.nextInt();

                    if (sortChoice == 1) {
                        Collections.sort(allOrders, new AmountComparator());
                    } 
                    else if (sortChoice == 2) {
                        Collections.sort(allOrders, new NameComparator());
                    } 
                    else if (sortChoice == 3) {
                        Collections.sort(allOrders, new PriorityComparator());
                    }

                    System.out.println("\n Orders:");
                    for (Order o : allOrders) {
                        System.out.println(o);
                    }
                    break;

                // Remove invalid  amount<100
                case 4:
                    Iterator<Order> it = allOrders.iterator();

                    while (it.hasNext()) {
                        Order o = it.next();

                        if (o.getAmount() < 100) {
                            it.remove();
                            orderIds.remove(o.getId());
                        }
                    }

                    System.out.println(" Invalid orders removed (amount < 100)");
                    break;

                // View specific Customer Orders
                case 5:
                    sc.nextLine();
                    System.out.print("Enter customer name: ");
                    String cname = sc.nextLine();

                    if (!customerMap.containsKey(cname)) {
                        System.out.println("No orders found.");
                    } else {
                        System.out.println(" Orders of " + cname + ":");
                        for (Order o : customerMap.get(cname)) {
                            System.out.println(o);
                        }
                    }
                    break;

                case 0:
                    System.out.println(" Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 0);

        sc.close();
    }
}
