package POCpackage;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TicketBookingSystem {
	  private Queue<String> ticketQueue;  

	    public TicketBookingSystem() {
	        ticketQueue = new LinkedList<>();
	    }
	    public void bookTicket(String customerName) {
	        ticketQueue.add(customerName);
	        System.out.println(customerName + " has booked a ticket.");
	    }
	    public void serveNextCustomer() {
	        if (!ticketQueue.isEmpty()) {
	            String servedCustomer = ticketQueue.poll();  // Removes the first customer in the queue
	            System.out.println(servedCustomer + " has been served.");
	        } else {
	            System.out.println("No customers in the queue.");
	        }
	    }
	    public void displayQueue() {
	        if (ticketQueue.isEmpty()) {
	            System.out.println("The queue is empty.");
	        } else {
	            System.out.println("Current Queue: " + ticketQueue);
	        }
	    }

	    public static void main(String[] args) {
	        TicketBookingSystem bookingSystem = new TicketBookingSystem();
	        Scanner scanner = new Scanner(System.in);

	        while (true) {
	            System.out.println("\n1. Book Ticket\n2. Serve Next Customer\n3. Show Queue\n4. Exit");
	            System.out.print("Enter your choice: ");
	            int choice = scanner.nextInt();
	            scanner.nextLine(); 

	            switch (choice) {
	                case 1:
	                    System.out.print("Enter Customer Name: ");
	                    String name = scanner.nextLine();
	                    bookingSystem.bookTicket(name);
	                    break;
	                case 2:
	                    bookingSystem.serveNextCustomer();
	                    break;
	                case 3:
	                    bookingSystem.displayQueue();
	                    break;
	                case 4:
	                    System.out.println("Existing");
	                    scanner.close();
	                    return;
	                default:
	                    System.out.println("Invalid,Please enter a valid option.");
	            }
	        }
	    }
}
