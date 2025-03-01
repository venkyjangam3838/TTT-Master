package com.poc;

import java.util.*;

//Student Marks Management System
class StudentMarksManagement {
 private Map<String, List<Integer>> studentMarks = new HashMap<>();

 // Add marks for a student
 public void addMarks(String name, int mark) {
     studentMarks.putIfAbsent(name, new ArrayList<>());
     studentMarks.get(name).add(mark);
     System.out.println("Added mark " + mark + " for " + name);
 }

 // Calculate average marks for a student
 public double getAverageMarks(String name) {
     List<Integer> marks = studentMarks.get(name);
     if (marks == null || marks.isEmpty()) {
         System.out.println("No marks found for " + name);
         return 0;
     }
     return marks.stream().mapToInt(Integer::intValue).average().orElse(0.0);
 }

 // Display all student data
 public void displayAllStudents() {
     if (studentMarks.isEmpty()) {
         System.out.println("No student records available.");
         return;
     }
     studentMarks.forEach((name, marks) -> 
         System.out.println("Student: " + name + ", Marks: " + marks + ", Average: " + getAverageMarks(name))
     );
 }
}

//Main class to test the functionality
public class StudentSystem {
 public static void main(String[] args) {
     StudentMarksManagement smm = new StudentMarksManagement();
     
     // Adding student marks
     smm.addMarks("Mobee", 85);
     smm.addMarks("Anu", 90);
     smm.addMarks("Bunny", 75);
     smm.addMarks("priya", 80);
     smm.addMarks("Naveen", 95);
     
     // Display all student records
     System.out.println("\nAll Students Data:");
     smm.displayAllStudents();
 }
}

