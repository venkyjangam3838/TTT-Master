package poc.tbs;

import java.util.LinkedList;
import java.util.Queue;

class TicketBookingSystem {
	private Queue<String> bookingQueue;

	public TicketBookingSystem() {
		bookingQueue = new LinkedList<>();
	}

	public void addCustomer(String customerName) {
		bookingQueue.offer(customerName);
		System.out.println(customerName + " has booked a ticket.");
	}

	public void processNextCustomer() {
		if (!bookingQueue.isEmpty()) {
			String servedCustomer = bookingQueue.poll();
			System.out.println(servedCustomer + " has been served.");
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

	public static void main(String[] args) {
		TicketBookingSystem system = new TicketBookingSystem();

		system.addCustomer("Venky");
		system.addCustomer("Mohan");
		system.addCustomer("Krishna");

		system.displayPendingBookings();

		system.processNextCustomer();
		system.processNextCustomer();

		system.displayPendingBookings();
	}
}
