package com.TicketBooking.in;

import java.util.LinkedList;
import java.util.Queue;

	public class TicketBookingSystem {
	    private Queue<String> bookingQueue;

	    public TicketBookingSystem() {
	        this.bookingQueue = new LinkedList<>();
	    }

	    // Getter
	    public Queue<String> getBookingQueue() {
	        return bookingQueue;
	    }

	    // Setter
	    public void setBookingQueue(Queue<String> bookingQueue) {
	        this.bookingQueue = bookingQueue;
	    }

	    // Add customer to the queue
	    public void addCustomer(String customerName) {
	        bookingQueue.add(customerName);
	        System.out.println(customerName + " added to the queue.");
	    }

	    // Process the next customer (FIFO order)
	    public void processNextCustomer() {
	        if (!bookingQueue.isEmpty()) {
	            String servedCustomer = bookingQueue.poll(); // Removes and returns the first element
	            System.out.println(servedCustomer + " has been served.");
	        } else {
	            System.out.println("No customers in the queue.");
	        }
	    }

	    // Display all pending bookings
	    public void displayPendingBookings() {
	        if (!bookingQueue.isEmpty()) {
	            System.out.println("Pending Bookings: " + bookingQueue);
	        } else {
	            System.out.println("No pending bookings.");
	        }
	    }

	    public static void main(String[] args) {
	        TicketBookingSystem ticketSystem = new TicketBookingSystem();

	        // Adding customers
	        ticketSystem.addCustomer("Sravani");
	        ticketSystem.addCustomer("Veeraiah");
	        ticketSystem.addCustomer("Honey");

	        // Display pending bookings
	        ticketSystem.displayPendingBookings();

	        // Processing customers
	        ticketSystem.processNextCustomer();
	        ticketSystem.processNextCustomer();

	        // Display remaining bookings
	        ticketSystem.displayPendingBookings();

	        // Process remaining customer
	        ticketSystem.processNextCustomer();
	        ticketSystem.processNextCustomer(); // Should display "No customers in the queue."
	    }
	}