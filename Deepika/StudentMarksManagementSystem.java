package POCpackage;


import java.util.*;

public class StudentMarksManagementSystem {
	    private Map<String, List<Integer>> studentMarks;

	    public StudentMarksManagementSystem() {
	        studentMarks = new HashMap<>();
	    }

	    // Method to add marks for a student
	    public void addMarks(String studentName, int mark) {
	        studentMarks.putIfAbsent(studentName, new ArrayList<>());
	        studentMarks.get(studentName).add(mark);
	        System.out.println("Added mark " + mark + " for student " + studentName);
	    }

	    // Method to calculate the average marks of a student
	    public double getAverageMarks(String studentName) {
	        List<Integer> marks = studentMarks.get(studentName);
	        if (marks == null || marks.isEmpty()) {
	            System.out.println("No marks found for " + studentName);
	            return 0.0;
	        }

	        double sum = 0;
	        for (int mark : marks) {
	            sum += mark;
	        }
	        return sum / marks.size();
	    }

	    // Method to display all student data
	    public void displayAllStudents() {
	        if (studentMarks.isEmpty()) {
	            System.out.println("No student data available.");
	            return;
	        }

	        System.out.println("\nStudent Data:");
	        for (Map.Entry<String, List<Integer>> entry : studentMarks.entrySet()) {
	            System.out.println("Student: " + entry.getKey() + ", Marks: " + entry.getValue());
	        }
	    }

	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        StudentMarksManagementSystem marksManagement = new StudentMarksManagementSystem();

	        while (true) {
	            System.out.println("\n1. Add Marks");
	            System.out.println("2. Get Average Marks");
	            System.out.println("3. Display All Students");
	            System.out.println("4. Exit");
	            System.out.print("Enter your choice: ");

	            int choice = scanner.nextInt();
	            scanner.nextLine(); // Consume newline

	            switch (choice) {
	                case 1:
	                    System.out.print("Enter Student Name: ");
	                    String studentName = scanner.nextLine();
	                    System.out.print("Enter Marks: ");
	                    int mark = scanner.nextInt();
	                    marksManagement.addMarks(studentName, mark);
	                    break;

	                case 2:
	                    System.out.print("Enter Student Name: ");
	                    String nameForAvg = scanner.nextLine();
	                    double avg = marksManagement.getAverageMarks(nameForAvg);
	                    if (avg > 0) {
	                        System.out.println("Average Marks of " + nameForAvg + ": " + avg);
	                    }
	                    break;

	                case 3:
	                    marksManagement.displayAllStudents();
	                    break;

	                case 4:
	                    System.out.println("Exiting the system...");
	                    scanner.close();
	                    return;

	                default:
	                    System.out.println("Invalid choice! Please enter a valid option.");
	            }
	       }
	  }
	
}
