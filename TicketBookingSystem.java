package com28mins.com;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TicketBookingSystem {

    // Queue to store customer names
    private static final Queue<String> customerQueue = new LinkedList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nTicket Booking System");
            System.out.println("1. Add a Customer to the Queue");
            System.out.println("2. Process the Next Customer");
            System.out.println("3. Display Pending Bookings");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addCustomer(scanner);
                    break;
                case 2:
                    processNextCustomer();
                    break;
                case 3:
                    displayPendingBookings();
                    break;
                case 4:
                    System.out.println("Exiting the system. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    // Method to add a customer to the queue
    private static void addCustomer(Scanner scanner) {
        System.out.print("Enter customer name: ");
        String name = scanner.nextLine();
        customerQueue.add(name);
        System.out.println("Customer " + name + " added to the queue.");
    }

    // Method to process the next customer
    private static void processNextCustomer() {
        if (customerQueue.isEmpty()) {
            System.out.println("No customers in the queue.");
        } else {
            String nextCustomer = customerQueue.poll();
            System.out.println("Processing customer: " + nextCustomer);
        }
    }

    // Method to display pending bookings
    private static void displayPendingBookings() {
        if (customerQueue.isEmpty()) {
            System.out.println("No pending bookings.");
        } else {
            System.out.println("\nPending Bookings:");
            for (String customer : customerQueue) {
                System.out.println("Customer: " + customer);
            }
        }
    }
}
