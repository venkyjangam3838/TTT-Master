package com.ttt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class StudentMarksManagementSystem {
	
	private Map<String, List<Integer>> studentMarks;
    private Scanner scanner;

    public StudentMarksManagementSystem() {
        this.studentMarks = new HashMap<>();
        this.scanner = new Scanner(System.in);
    }

    public void addMarksForStudent() {
        System.out.print("Enter student name: ");
        String studentName = scanner.nextLine();
        System.out.print("Enter number of subjects: ");
        int numSubjects = Integer.parseInt(scanner.nextLine());

        if (!studentMarks.containsKey(studentName)) {
            studentMarks.put(studentName, new ArrayList<>());
        }

        for (int i = 0; i < numSubjects; i++) {
            System.out.print("Enter marks for subject " + (i + 1) + ": ");
            int marks = Integer.parseInt(scanner.nextLine());
            studentMarks.get(studentName).add(marks);
        }

        System.out.println("Marks added successfully!");
    }

    public void calculateAverageMarksForStudent() {
        System.out.print("Enter student name: ");
        String studentName = scanner.nextLine();

        if (studentMarks.containsKey(studentName)) {
            List<Integer> marks = studentMarks.get(studentName);
            double average = marks.stream().mapToInt(Integer::intValue).average().orElse(0.0);
            System.out.println("Average marks for " + studentName + ": " + average);
        } else {
            System.out.println("Student not found!");
        }
    }

    public void displayAllStudentData() {
        for (Map.Entry<String, List<Integer>> entry : studentMarks.entrySet()) {
            System.out.println("Student Name: " + entry.getKey());
            System.out.println("Marks: " + entry.getValue());
            System.out.println();
        }
    }

    public void run() {
        while (true) {
            System.out.println("1. Add marks for student");
            System.out.println("2. Calculate average marks for student");
            System.out.println("3. Display all student data");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    addMarksForStudent();
                    break;
                case 2:
                    calculateAverageMarksForStudent();
                    break;
                case 3:
                    displayAllStudentData();
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
        StudentMarksManagementSystem smms = new StudentMarksManagementSystem();
        smms.run();
    }


}
