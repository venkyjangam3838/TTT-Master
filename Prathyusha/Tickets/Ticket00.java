package Tickets;

import java.util.LinkedList;
import java.util.Queue;

public class Ticket00 {

   
    private Queue<String> customerQueue;

    
    public Ticket00() {
        customerQueue = new LinkedList<>();
    }

    
    public void addCustomer(String customerName) {
        customerQueue.add(customerName);
        System.out.println("Customer " + customerName + " has been added to the queue.");
    }

    
    public void processNextCustomer() {
        if (!customerQueue.isEmpty()) {
            String nextCustomer = customerQueue.poll();
            System.out.println("Processing ticket for customer: " + nextCustomer);
        } else {
            System.out.println("No customers in the queue.");
        }
    }

   
    public void displayPendingBookings() {
        if (!customerQueue.isEmpty()) {
            System.out.println("Pending bookings:");
            for (String customer : customerQueue) {
                System.out.println(customer);
            }
        } else {
            System.out.println("No pending bookings.");
        }
    }

   
    public static void main(String[] args) {
        Ticket00 bookingSystem = new Ticket00();        
        
        
        bookingSystem.addCustomer("Monish");
        bookingSystem.addCustomer("Nikhil");
        bookingSystem.addCustomer("Jagadeesh");

        
        bookingSystem.displayPendingBookings();

       
     
        bookingSystem.processNextCustomer();
        bookingSystem.processNextCustomer();

        
        bookingSystem.displayPendingBookings();
    }
}
