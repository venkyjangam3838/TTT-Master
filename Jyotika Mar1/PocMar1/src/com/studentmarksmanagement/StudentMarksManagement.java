package com.studentmarksmanagement;

import java.util.*;

public class StudentMarksManagement {
    private static final Map<String, List<Integer>> studentMarks = new HashMap<>();
    private static final Scanner scanner = new Scanner(System.in);

    // Method to add marks for a student
    public static void addMarks() {
        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter number of subjects: ");
        int numSubjects = scanner.nextInt();
        List<Integer> marks = new ArrayList<>();

        System.out.println("Enter marks: ");
        for (int i = 0; i < numSubjects; i++) {
            marks.add(scanner.nextInt());
        }
        scanner.nextLine(); // Consume newline

        studentMarks.put(name, marks);
        System.out.println("Marks added successfully!");
    }

    // Method to calculate the average marks of a student
    public static void calculateAverageMarks() {
        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();

        if (studentMarks.containsKey(name)) {
            List<Integer> marks = studentMarks.get(name);
            double average = marks.stream().mapToInt(Integer::intValue).average().orElse(0.0);
            System.out.println("Average Marks of " + name + ": " + average);
        } else {
            System.out.println("Student not found.");
        }
    }

    // Method to display all student data
    public static void displayAllStudents() {
        if (studentMarks.isEmpty()) {
            System.out.println("No student data available.");
        } else {
            for (Map.Entry<String, List<Integer>> entry : studentMarks.entrySet()) {
                System.out.println("Student: " + entry.getKey() + ", Marks: " + entry.getValue());
            }
        }
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n1. Add Marks\n2. Calculate Average Marks\n3. Display All Students\n4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> addMarks();
                case 2 -> calculateAverageMarks();
                case 3 -> displayAllStudents();
                case 4 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice, try again.");
            }
        }
    }
}

