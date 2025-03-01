package com.learn.poc;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Employee {
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

    public int getId() { return id; }
    public String getName() { return name; }
    public String getDesignation() { return designation; }
    public double getSalary() { return salary; }

    @Override
    public String toString() {
        return "Employee { ID: " + id + ", Name: " + name + ", Designation: " + designation + ", Salary: " + salary + " }";
    }
}

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
    public void removeEmployee(int id) {
        employees.removeIf(emp -> emp.getId() == id);
        System.out.println("Employee with ID " + id + " removed.");
    }

    // Sort employees by salary
    public void sortEmployeesBySalary() {
        employees.sort(Comparator.comparingDouble(Employee::getSalary));
        System.out.println("Employees sorted by salary.");
    }

    // Search for an employee by name
    public Employee searchEmployeeByName(String name) {
        for (Employee emp : employees) {
            if (emp.getName().equalsIgnoreCase(name)) {
                return emp;
            }
        }
        return null;
    }

    // Display all employees
    public void displayEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employees available.");
        } else {
            employees.forEach(System.out::println);
        }
    }
    


   
}
