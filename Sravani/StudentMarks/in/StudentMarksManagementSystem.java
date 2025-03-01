package com.StudentMarks.in;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Student Marks Management System
class StudentMarksManagement {
    private Map<String, List<Integer>> studentMarks;

    public StudentMarksManagement() {
        studentMarks = new HashMap<>();
    }

    // Method to add marks for a student
    public void addMarks(String studentName, int mark) {
        studentMarks.putIfAbsent(studentName, new ArrayList<>());
        studentMarks.get(studentName).add(mark);
    }

    // Method to calculate the average marks of a student
    public double calculateAverageMarks(String studentName) {
        List<Integer> marks = studentMarks.get(studentName);
        if (marks == null || marks.isEmpty()) {
            return 0.0;
        }
        int sum = marks.stream().mapToInt(Integer::intValue).sum();
        return (double) sum / marks.size();
    }

    // Method to display all student data
    public void displayAllStudents() {
        for (Map.Entry<String, List<Integer>> entry : studentMarks.entrySet()) {
            System.out.println("Student: " + entry.getKey() + ", Marks: " + entry.getValue());
        }
    }
}

// Main class for testing
public class StudentMarksManagementSystem {
    public static void main(String[] args) {
        StudentMarksManagement system = new StudentMarksManagement();

        // Adding marks for students
        system.addMarks("Sravani", 55);
        system.addMarks("Sravani", 90);
        system.addMarks("Sirisha", 75);
        system.addMarks("Sirisha", 100);
        system.addMarks("Preeti", 95);

        // Display all students
        System.out.println("All Student Data:");
        system.displayAllStudents();

        // Calculating and displaying average marks
        System.out.println("\nAverage Marks:");
        System.out.println("Sravani: " + system.calculateAverageMarks("Sravani"));
        System.out.println("Sirisha: " + system.calculateAverageMarks("Sirisha"));
        System.out.println("Preeti: " + system.calculateAverageMarks("Preeti"));
    }
}
