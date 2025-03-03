package com28mins.com;

import java.util.*;

//Employee class
class Employee {
 private int id;
 private String name;
 private String designation;
 private double salary;

 // Constructor
 public Employee(int id, String name, String designation, double salary) {
     this.id = id;
     this.name = name;
     this.designation = designation;
     this.salary = salary;
 }

 // Getters and Setters
 public int getId() {
     return id;
 }

 public String getName() {
     return name;
 }

 public String getDesignation() {
     return designation;
 }

 public double getSalary() {
     return salary;
 }

 @Override
 public String toString() {
     return "Employee{" +
             "id=" + id +
             ", name='" + name + '\'' +
             ", designation='" + designation + '\'' +
             ", salary=" + salary +
             '}';
 }
}

//Employee Management System
public class EmployeeManagementSystem {
 private static final List<Employee> employees = new ArrayList<>();

 public static void main(String[] args) {
     Scanner scanner = new Scanner(System.in);
     while (true) {
         System.out.println("\nEmployee Management System");
         System.out.println("1. Add a New Employee");
         System.out.println("2. Remove an Employee by ID");
         System.out.println("3. Sort Employees by Salary");
         System.out.println("4. Search for an Employee by Name");
         System.out.println("5. Display All Employees");
         System.out.println("6. Exit");
         System.out.print("Choose an option: ");
         int choice = scanner.nextInt();
         scanner.nextLine(); // Consume newline

         switch (choice) {
             case 1:
                 addEmployee(scanner);
                 break;
             case 2:
                 removeEmployeeById(scanner);
                 break;
             case 3:
                 sortEmployeesBySalary();
                 break;
             case 4:
                 searchEmployeeByName(scanner);
                 break;
             case 5:
                 displayAllEmployees();
                 break;
             case 6:
                 System.out.println("Exiting the system. Goodbye!");
                 scanner.close();
                 return;
             default:
                 System.out.println("Invalid option. Please try again.");
         }
     }
 }

 // Method to add a new employee
 private static void addEmployee(Scanner scanner) {
     System.out.print("Enter employee ID: ");
     int id = scanner.nextInt();
     scanner.nextLine(); // Consume newline

     System.out.print("Enter employee name: ");
     String name = scanner.nextLine();

     System.out.print("Enter employee designation: ");
     String designation = scanner.nextLine();

     System.out.print("Enter employee salary: ");
     double salary = scanner.nextDouble();
     scanner.nextLine(); // Consume newline

     employees.add(new Employee(id, name, designation, salary));
     System.out.println("Employee added successfully.");
 }

 // Method to remove an employee by ID
 private static void removeEmployeeById(Scanner scanner) {
     System.out.print("Enter employee ID to remove: ");
     int id = scanner.nextInt();
     scanner.nextLine(); // Consume newline

     boolean removed = employees.removeIf(employee -> employee.getId() == id);
     if (removed) {
         System.out.println("Employee with ID " + id + " removed successfully.");
     } else {
         System.out.println("Employee with ID " + id + " not found.");
     }
 }

 // Method to sort employees by salary
 private static void sortEmployeesBySalary() {
     employees.sort(Comparator.comparingDouble(Employee::getSalary));
     System.out.println("Employees sorted by salary.");
 }

 // Method to search for an employee by name
 private static void searchEmployeeByName(Scanner scanner) {
     System.out.print("Enter employee name to search: ");
     String name = scanner.nextLine();

     List<Employee> result = employees.stream()
             .filter(employee -> employee.getName().equalsIgnoreCase(name))
             .toList();

     if (result.isEmpty()) {
         System.out.println("No employee found with name: " + name);
     } else {
         System.out.println("Search results:");
         result.forEach(System.out::println);
     }
 }

 // Method to display all employees
 private static void displayAllEmployees() {
     if (employees.isEmpty()) {
         System.out.println("No employees found.");
     } else {
         System.out.println("\nAll Employees:");
         employees.forEach(System.out::println);
     }
 }
}
