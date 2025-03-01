package com.poc;

import java.util.*;

//Ticket Booking System
class TicketBookingSystem {
 private Queue<String> bookingQueue = new LinkedList<>();

 // customer  queue
 public void addCustomer(String name) {
     bookingQueue.offer(name);
     System.out.println(name + " added to the booking queue.");
 }

 // Process the next customer (FIFO order)
 public void processNextCustomer() {
     if (!bookingQueue.isEmpty()) {
         String customer = bookingQueue.poll();
         System.out.println("Processing booking for: " + customer);
     } else {
         System.out.println("No bookings to process.");
     }
 }

 // Display the pending bookings
 public void displayPendingBookings() {
     if (bookingQueue.isEmpty()) {
         System.out.println("No pending bookings.");
     } else {
         System.out.println("Pending bookings: " + bookingQueue);
     }
 }
}

//Main class to test the functionality
public class TicketSystem {
 public static void main(String[] args) {
     TicketBookingSystem tbs = new TicketBookingSystem();
     
     // Adding customers to the queue
     tbs.addCustomer("Alice");
     tbs.addCustomer("Bob");
     tbs.addCustomer("Charlie");
     
     // Display pending bookings
     tbs.displayPendingBookings();
     
     // Processing customers
     tbs.processNextCustomer();
     tbs.processNextCustomer();
     
     // Display pending bookings after processing
     tbs.displayPendingBookings();
 }
}
