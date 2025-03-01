package com.ticketbookingsystem;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TicketBookingSystem {
    private Queue<String> bookingQueue = new LinkedList<>();

    public void addCustomer(String customerName) {
        bookingQueue.offer(customerName);
    }

    public void processNextCustomer() {
        if (!bookingQueue.isEmpty()) {
            System.out.println(bookingQueue.poll() + " has been served.");
        } else {
            System.out.println("No pending bookings.");
        }
    }

    public void displayPendingBookings() {
        System.out.println("Pending Bookings: " + bookingQueue);
    }

    public static void main(String[] args) {
        TicketBookingSystem system = new TicketBookingSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add Customer\n2. Process Next Customer\n3. Display Pending Bookings\n4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter customer name: ");
                    String name = scanner.nextLine();
                    system.addCustomer(name);
                    break;
                case 2:
                    system.processNextCustomer();
                    break;
                case 3:
                    system.displayPendingBookings();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}



