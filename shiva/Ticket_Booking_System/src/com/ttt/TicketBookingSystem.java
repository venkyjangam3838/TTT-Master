package com.ttt;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TicketBookingSystem {
	private Queue<String> bookingQueue;
	private Scanner scanner;

	public TicketBookingSystem() {
		this.bookingQueue = new LinkedList<>();
		this.scanner = new Scanner(System.in);
	}

	public void addCustomerToQueue() {
		System.out.print("Enter customer name: ");
		String customerName = scanner.nextLine();
		bookingQueue.add(customerName);
		System.out.println(customerName + " added to the queue.");
	}


	public void processNextCustomer() {
		if (!bookingQueue.isEmpty()) {
			String nextCustomer = bookingQueue.poll();
			System.out.println("Processing " + nextCustomer + "'s booking...");
		} else {
			System.out.println("No pending bookings.");
		}
	}

	public void displayPendingBookings() {
		if (!bookingQueue.isEmpty()) {
			System.out.println("Pending bookings:");
			for (String customer : bookingQueue) {
				System.out.println(customer);
			}
		} else {
			System.out.println("No pending bookings.");
		}
	}

	public void run() {
		while (true) {
			System.out.println("1. Add customer to queue");
			System.out.println("2. Process next customer");
			System.out.println("3. Display pending bookings");
			System.out.println("4. Exit");
			System.out.print("Enter your choice: ");
			int choice = Integer.parseInt(scanner.nextLine());

			switch (choice) {
			case 1:
				addCustomerToQueue();
				break;
			case 2:
				processNextCustomer();
				break;
			case 3:
				displayPendingBookings();
				break;
			case 4:
				System.out.println("Exiting...");
				return;
			default:
				System.out.println("Invalid choice. Please try again.");
			}
		}
	}

	public static void main(String[] args) {
		TicketBookingSystem tbs = new TicketBookingSystem();
		tbs.run();
	}




}
