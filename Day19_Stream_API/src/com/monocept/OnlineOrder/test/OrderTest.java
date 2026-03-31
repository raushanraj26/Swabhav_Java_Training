package com.monocept.OnlineOrder.test;
import com.monocept.OnlineOrder.model.*;



import java.util.*;
import java.util.stream.Collectors;

public class OrderTest {

    static Scanner sc = new Scanner(System.in);
    static List<Order> orders = new ArrayList<>();

    public static void main(String[] args) {

        int choice=0;

        do {
            System.out.println("\n===== ONLINE ORDER SYSTEM =====");
            System.out.println("1. Add Order");
            System.out.println("2. Show Completed Orders");
            System.out.println("3. Total Revenue (Completed)");
            System.out.println("4. Group by Category");
            System.out.println("5. Maximum Order Amount");
            System.out.println("6. Count Cancelled Orders");
            System.out.println("7. Map OrderId -> Amount");
            System.out.println("8. Sort Customers by Amount Desc");
            System.out.println("9. Exit");
            System.out.print("Enter choice: ");

            // Input validation
            if (!sc.hasNextInt()) {
                System.out.println("Invalid input! Enter number.");
                sc.next();
                continue;
            }

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    addOrder();
                    break;

                case 2:
                    ifEmpty();
                    showCompleted();
                    break;

                case 3:
                    ifEmpty();
                    totalRevenue();
                    break;

                case 4:
                    ifEmpty();
                    groupByCategory();
                    break;

                case 5:
                    ifEmpty();
                    maxOrder();
                    break;

                case 6:
                    ifEmpty();
                    countCancelled();
                    break;

                case 7:
                    ifEmpty();
                    mapOrder();
                    break;

                case 8:
                    ifEmpty();
                    sortCustomers();
                    break;

                case 9:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 9);
    }

    // ✅ Check empty list
    static void ifEmpty() {
        if (orders.isEmpty()) {
            System.out.println("No orders available!");
            throw new RuntimeException(); // stops further execution of case
        }
    }

    // ✅ Add Order
    static void addOrder() {
        try {
            System.out.print("Order ID: ");
            int id = sc.nextInt();

            System.out.print("Customer Name: ");
            String name = sc.next();

            System.out.print("Category: ");
            String category = sc.next();

            System.out.print("Amount: ");
            double amount = sc.nextDouble();

            System.out.print("Status (completed/cancelled/pending): ");
            String status = sc.next();

            orders.add(new Order(id, name, category, amount, status));
            System.out.println("Order added successfully!");

        } catch (Exception e) {
            System.out.println("Invalid input!");
            sc.nextLine();
        }
    }

    // 1️⃣ Get all completed orders (filter)
    static void showCompleted() {
        List<Order> result = orders.stream()
                .filter(o -> o.getStatus().equalsIgnoreCase("completed"))
                .collect(Collectors.toList());

        result.forEach(System.out::println);
    }

    // 2️⃣ Total revenue (reduce)
    static void totalRevenue() {
        double sum = orders.stream()
                .filter(o -> o.getStatus().equalsIgnoreCase("completed"))
                .map(Order::getAmount)
                .reduce(0.0, Double::sum);

        System.out.println("Total Revenue: " + sum);
    }

    // 3️⃣ Group by category
    static void groupByCategory() {
        Map<String, List<Order>> map = orders.stream()
                .collect(Collectors.groupingBy(Order::getCategory));

        map.forEach((k, v) -> {
            System.out.println("Category: " + k);
            v.forEach(System.out::println);
        });
    }

    // 4️⃣ Max order amount
    static void maxOrder() {
        Optional<Order> max = orders.stream()
                .max(Comparator.comparingDouble(Order::getAmount));

        max.ifPresent(System.out::println);
    }

    // 5️⃣ Count cancelled
    static void countCancelled() {
        long count = orders.stream()
                .filter(o -> o.getStatus().equalsIgnoreCase("cancelled"))
                .count();

        System.out.println("Cancelled Orders: " + count);
    }

    // 6️⃣ Map orderId -> amount
    static void mapOrder() {
        Map<Integer, Double> map = orders.stream()
                .collect(Collectors.toMap(Order::getOrderId, Order::getAmount));

        map.forEach((k, v) -> System.out.println(k + " -> " + v));
    }

    // 7️⃣ Sort customers by amount desc
    static void sortCustomers() {
        List<String> list = orders.stream()
                .sorted((a, b) -> Double.compare(b.getAmount(), a.getAmount()))
                .map(Order::getCustomerName)
                .collect(Collectors.toList());

        list.forEach(System.out::println);
    }
}