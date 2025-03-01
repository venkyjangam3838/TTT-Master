package studentMarks;

import java.util.*;

//Student Marks Management System Class
class StudentMarksManagementSystem {
 private Map<String, List<Integer>> studentMarksMap;

 public StudentMarksManagementSystem() {
     studentMarksMap = new HashMap<>();
 }

 // Add marks for a student
 public void addMarks(String studentName, List<Integer> marks) {
     studentMarksMap.put(studentName, marks);
     System.out.println("Added marks for student: " + studentName);
 }

 // Calculate the average marks of a student
 public double calculateAverageMarks(String studentName) {
     List<Integer> marks = studentMarksMap.get(studentName);
     if (marks == null || marks.isEmpty()) {
         System.out.println("No marks found for student: " + studentName);
         return 0.0;
     }
     double sum = 0;
     for (int mark : marks) {
         sum += mark;
     }
     return sum / marks.size();
 }

 // Display all student data
 public void displayAllStudentData() {
     if (studentMarksMap.isEmpty()) {
         System.out.println("No student data available.");
     } else {
         for (Map.Entry<String, List<Integer>> entry : studentMarksMap.entrySet()) {
             String studentName = entry.getKey();
             List<Integer> marks = entry.getValue();
             System.out.println("Student: " + studentName + ", Marks: " + marks + ", Average Marks: " + calculateAverageMarks(studentName));
         }
     }
 }
}

//Main class to test the Student Marks Management System
public class StudentMarksManagement {
 public static void main(String[] args) {
     // Creating an instance of StudentMarksManagementSystem
     StudentMarksManagementSystem smms = new StudentMarksManagementSystem();

     // Adding marks for students
     smms.addMarks("Alice", Arrays.asList(85, 90, 92));
     smms.addMarks("Bob", Arrays.asList(78, 83, 89));
     smms.addMarks("Charlie", Arrays.asList(88, 94, 91));

     // Displaying all student data
     System.out.println("\nDisplaying all student data:");
     smms.displayAllStudentData();

     // Calculate and display average marks for a specific student
     System.out.println("\nAverage marks for Bob: " + smms.calculateAverageMarks("Bob"));
     System.out.println("Average marks for Alice: " + smms.calculateAverageMarks("Alice"));
     System.out.println("Average marks for Charlie: " + smms.calculateAverageMarks("Charlie"));
 }
}
