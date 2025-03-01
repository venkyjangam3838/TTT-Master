package com.learn.poc;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TicketBookingSystem {
	private Queue<String> bookingQueue;

    public TicketBookingSystem() {
        bookingQueue = new LinkedList<>();
    }

    // Method to add a customer to the queue
    public void addCustomer(String customerName) {
        bookingQueue.add(customerName);
        System.out.println(customerName + " has been added to the booking queue.");
    }

    // Method to process the next customer (FIFO order)
    public void processNextCustomer() {
        if (!bookingQueue.isEmpty()) {
            String servedCustomer = bookingQueue.poll();
            System.out.println(servedCustomer + " has been processed and removed from the queue.");
        } else {
            System.out.println("No customers in the queue to process.");
        }
    }

    // Method to display pending bookings
    public void displayPendingBookings() {
        if (!bookingQueue.isEmpty()) {
            System.out.println("Pending Bookings: " + bookingQueue);
        } else {
            System.out.println("No pending bookings.");
        }
    }

    public static void main(String[] args) {
        TicketBookingSystem system = new TicketBookingSystem();
        Scanner scan =new Scanner (System.in);
        System.out.println("enter your name");
    
        String n=scan.nextLine();
        String n1=scan.nextLine();
        String n2=scan.nextLine();
      
        
        
        system.addCustomer(n);
        system.addCustomer(n1);
        system.addCustomer(n2);
        
        system.displayPendingBookings();
        
        system.processNextCustomer();
        system.displayPendingBookings();
        
        system.processNextCustomer();
        system.processNextCustomer();
        system.processNextCustomer(); // This should indicate no customers left
    }
	

}
