package com.poc;

import java.util.*;

//Employee class with encapsulation
class Employee {
 private int id;
 private String name;
 private String designation;
 private double salary;

 public Employee(int id, String name, String designation, double salary) {
     this.id = id;
     this.name = name;
     this.designation = designation;
     this.salary = salary;
 }

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
     return "ID: " + id + ", Name: " + name + ", Designation: " + designation + ", Salary: " + salary;
 }
}

//Employee Management System
class EmployeeManagement {
 private List<Employee> employees = new ArrayList<>();

 public void addEmployee(Employee emp) {
     employees.add(emp);
 }

 public void removeEmployee(int id) {
     employees.removeIf(emp -> emp.getId() == id);
 }

 public Employee searchEmployee(String name) {
     for (Employee emp : employees) {
         if (emp.getName().equalsIgnoreCase(name)) {
             return emp;
         }
     }
     return null;
 }

 public void sortEmployeesBySalary() {
     employees.sort(Comparator.comparingDouble(Employee::getSalary));
 }

 public void displayEmployees() {
     employees.forEach(System.out::println);
 }
}

//Main class to test functionality
public class EmployeeSystem {
 public static void main(String[] args) {
     EmployeeManagement ems = new EmployeeManagement();
     ems.addEmployee(new Employee(1, "Anu", "Manager", 75000));
     ems.addEmployee(new Employee(2, "Bobby", "Developer", 60000));
     ems.addEmployee(new Employee(3, "Mona", "Analyst", 50000));
     
     System.out.println("Employees after addition:");
     ems.displayEmployees();
     
     ems.sortEmployeesBySalary();
     System.out.println("\nEmployees sorted by salary:");
     ems.displayEmployees();
     
     System.out.println("\nSearching for Bob:");
     System.out.println(ems.searchEmployee("Bob"));
     
     ems.removeEmployee(2);
     System.out.println("\nEmployees after removing Bob:");
     ems.displayEmployees();
 }
}
