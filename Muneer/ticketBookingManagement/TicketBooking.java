package ticketBookingManagement;

import java.util.*;

//Ticket Booking System class
class TicketBookingSystem {
 private Queue<String> customerQueue;

 public TicketBookingSystem() {
     customerQueue = new LinkedList<>();
 }

 // Add a customer to the queue
 public void addCustomerToQueue(String customerName) {
     customerQueue.offer(customerName); // Add customer to the queue (FIFO)
     System.out.println("Customer " + customerName + " added to the queue.");
 }

 // Process the next customer in the queue (FIFO)
 public void processNextCustomer() {
     String customer = customerQueue.poll(); // Remove and return the first customer (FIFO)
     if (customer != null) {
         System.out.println("Processing customer: " + customer);
     } else {
         System.out.println("No customers in the queue to process.");
     }
 }

 // Display pending bookings (Customers in the queue)
 public void displayPendingBookings() {
     if (customerQueue.isEmpty()) {
         System.out.println("No pending bookings.");
     } else {
         System.out.println("Pending bookings (customers in queue): " + customerQueue);
     }
 }
}

//Main class to test the Ticket Booking System
public class TicketBooking {
 public static void main(String[] args) {
     // Creating an instance of TicketBookingSystem
     TicketBookingSystem tbs = new TicketBookingSystem();

     // Adding customers to the queue
     tbs.addCustomerToQueue("Alice");
     tbs.addCustomerToQueue("Bob");
     tbs.addCustomerToQueue("Charlie");

     // Display pending bookings
     System.out.println("\nDisplaying pending bookings:");
     tbs.displayPendingBookings();

     // Processing customers in FIFO order
     System.out.println("\nProcessing customers:");
     tbs.processNextCustomer(); // Alice
     tbs.processNextCustomer(); // Bob
     tbs.processNextCustomer(); // Charlie

     // Display pending bookings after processing
     System.out.println("\nDisplaying pending bookings after processing:");
     tbs.displayPendingBookings();
 }
}

