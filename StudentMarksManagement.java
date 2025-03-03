package com28mins.com;


import java.util.*;

public class StudentMarksManagement{

    public static void main(String[] args){

        Map<String, List<Integer>> studentMarksMap = new HashMap<>();

        Scanner sc = new Scanner(System.in);
        int choice = 0;
        
        while (choice != 4) {
            System.out.println("\nStudent Marks Management System");
            System.out.println("1. Add Marks for Student");
            System.out.println("2. View Student Marks");
            System.out.println("3. Calculate Average Marks of a Student");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // Clear buffer

            switch (choice) {
                case 1:
                    addMarks(sc, studentMarksMap);
                    break;
                case 2:
                    viewMarks(sc, studentMarksMap);
                    break;
                case 3:
                    calculateAverage(sc, studentMarksMap);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

       


    }


    public static void addMarks(Scanner sc, Map<String, List<Integer>> studentMarksMap){
        System.out.println("Enter Student Name:");
        String studentName = sc.nextLine();

        System.out.println("Enter Student Marks (comma-separated):");
        sc.nextLine(); // Clear buffer
        String marksInput = sc.nextLine();
        
        List<Integer> marksList = new ArrayList<>();
        for (String mark : marksInput.split(",")) {
            marksList.add(Integer.parseInt(mark.trim()));
        }



    }

    public static void viewMarks(Scanner sc, Map<String, List<Integer>> studentMarksMap) {
        System.out.println("Enter Student Name:");
        String studentName = sc.nextLine();
        
        if (studentMarksMap.containsKey(studentName)) {
            System.out.println("Marks for " + studentName + ": " + studentMarksMap.get(studentName));
        } else {
            System.out.println("No marks found for " + studentName);
        }
    }
    
    public static void calculateAverage(Scanner sc, Map<String, List<Integer>> studentMarksMap) {
        System.out.println("Enter Student Name:");
        String studentName = sc.nextLine();
        
        if (studentMarksMap.containsKey(studentName)) {
            List<Integer> marks = studentMarksMap.get(studentName);
            double average = marks.stream().mapToInt(Integer::intValue).average().orElse(0.0);
            System.out.println("Average marks for " + studentName + ": " + average);
        } else {
            System.out.println("No marks found for " + studentName);
        }
    }
}
