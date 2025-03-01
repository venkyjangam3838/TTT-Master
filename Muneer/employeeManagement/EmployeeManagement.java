package employeeManagement;

import java.util.*;

public class EmployeeManagement {
public static void main(String[] args) {
    EmployeeManagementSystem ems = new EmployeeManagementSystem();

    // Create some Employee objects
    Employee e1 = new Employee(1, "Alice", "Manager", 60000);
    Employee e2 = new Employee(2, "Bob", "Developer", 50000);
    Employee e3 = new Employee(3, "Charlie", "Designer", 40000);
    Employee e4 = new Employee(4, "David", "Developer", 55000);

    // Add employees to the system
    ems.addEmployee(e1);
    ems.addEmployee(e2);
    ems.addEmployee(e3);
    ems.addEmployee(e4);

    // Display all employees
    System.out.println("\nAll Employees:");
    ems.displayEmployees();

    // Sort employees by salary
    ems.sortEmployeesBySalary();

    // Search for an employee by name
    System.out.println("\nSearching for 'Bob':");
    ems.searchEmployeeByName("Bob");

    // Remove an employee by ID
    System.out.println("\nRemoving employee with ID 3:");
    ems.removeEmployeeById(3);

    // Display employees after removal
    System.out.println("\nEmployees after removal:");
    ems.displayEmployees();
}
}


//Employee class with id, name, designation, and salary
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

 // Getters and setters
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

 // toString method to display employee information
 @Override
 public String toString() {
     return "Employee{id=" + id + ", name='" + name + "', designation='" + designation + "', salary=" + salary + "}";
 }
}

//Employee Management System Class
class EmployeeManagementSystem {
 private List<Employee> employees;

 public EmployeeManagementSystem() {
     employees = new ArrayList<>();
 }

 // Add a new employee
 public void addEmployee(Employee employee) {
     employees.add(employee);
     System.out.println("Added: " + employee);
 }

 // Remove an employee by ID
 public void removeEmployeeById(int id) {
     employees.removeIf(employee -> employee.getId() == id);
     System.out.println("Employee with ID " + id + " removed.");
 }

 // Sort employees by salary using Comparator
 public void sortEmployeesBySalary() {
     employees.sort(Comparator.comparingDouble(Employee::getSalary));
     System.out.println("Employees sorted by salary:");
     displayEmployees();
 }

 // Search for an employee by name
 public void searchEmployeeByName(String name) {
     boolean found = false;
     for (Employee employee : employees) {
         if (employee.getName().equalsIgnoreCase(name)) {
             System.out.println("Found employee: " + employee);
             found = true;
             break;
         }
     }
     if (!found) {
         System.out.println("No employee found with name: " + name);
     }
 }

 // Display all employees
 public void displayEmployees() {
     if (employees.isEmpty()) {
         System.out.println("No employees in the system.");
     } else {
         employees.forEach(System.out::println);
     }
 }
}

