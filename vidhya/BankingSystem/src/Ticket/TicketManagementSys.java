package Ticket;

import java.util.*;

class TicketBookingSystem {
    private Queue<String> bookingQueue;

    public TicketBookingSystem() {
        this.bookingQueue = new LinkedList<>();
    }

    public void bookTicket(String customerName) {
        if (customerName == null || customerName.trim().isEmpty()) {
            System.out.println("Invalid customer name.");
            return;
        }
        bookingQueue.offer(customerName);
        System.out.println(customerName + " has booked a ticket.");
    }

    public void processNextBooking() {
        if (!bookingQueue.isEmpty()) {
            String customer = bookingQueue.poll();
            System.out.println("Processing ticket for: " + customer);
        } else {
            System.out.println("No pending bookings.");
        }
    }

    public void displayPendingBookings() {
        if (bookingQueue.isEmpty()) {
            System.out.println("No pending bookings.");
        } else {
            System.out.println("Pending Bookings: " + bookingQueue);
        }
    }
}

public class TicketManagementSys {
    public static void main(String[] args) {
        TicketBookingSystem tbs = new TicketBookingSystem();
        tbs.bookTicket("vidhya");
        tbs.bookTicket("yathish");
        tbs.bookTicket("Pooja");

        System.out.println("\nCurrent Queue:");
        tbs.displayPendingBookings();

        System.out.println("\nProcessing Bookings:");
        tbs.processNextBooking();
        tbs.processNextBooking();

        System.out.println("\nUpdated Queue:");
        tbs.displayPendingBookings();
    }
}
