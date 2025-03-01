package com.learn.poc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentMarksManagement {
	private Map<String, List<Integer>> studentMarks;

    public StudentMarksManagement() {
        studentMarks = new HashMap<>();
    }

    // Method to add marks for a student
    public void addMarks(String studentName, int mark) {
        studentMarks.putIfAbsent(studentName, new ArrayList<>());
        studentMarks.get(studentName).add(mark);
        System.out.println("Added mark " + mark + " for student " + studentName);
    }

    // Method to calculate the average marks of a student
    public double calculateAverage(String studentName) {
        if (!studentMarks.containsKey(studentName) || studentMarks.get(studentName).isEmpty()) {
            System.out.println("No marks found for student " + studentName);
            return 0.0;
        }
        List<Integer> marks = studentMarks.get(studentName);
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
        for (Map.Entry<String, List<Integer>> entry : studentMarks.entrySet()) {
            System.out.println("Student: " + entry.getKey() + " | Marks: " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        StudentMarksManagement system = new StudentMarksManagement();
        
        system.addMarks("Alice", 85);
        system.addMarks("Alice", 90);
        system.addMarks("Bob", 78);
        system.addMarks("Bob", 82);
        
        system.displayAllStudents();
        
        System.out.println("Alice's Average: " + system.calculateAverage("Alice"));
        System.out.println("Bob's Average: " + system.calculateAverage("Bob"));
        System.out.println("Charlie's Average: " + system.calculateAverage("Charlie")); // No data case
    }
}
