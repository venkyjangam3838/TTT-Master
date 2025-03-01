package com.employee;

import java.util.*;

class Employee {
    private int id;
    private String name;
    private String role;
    private double salary;

    public Employee(int id, String name, String role, double salary) {
        this.id = id;
        this.name = name;
        this.role = role;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee:" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", role='" + role + '\'' +
                ", salary=" + salary ;
    }
}

class EmployeeManagement {
    private List<Employee> employees = new ArrayList<>();

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public boolean removeEmployeeById(int id) {
        return employees.removeIf(emp -> emp.getId() == id);
    }

    public void sortEmployeesBySalary() {
        employees.sort(Comparator.comparingDouble(Employee::getSalary));
    }

    public Employee searchEmployeeByName(String name) {
        return employees.stream()
                .filter(emp -> emp.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }

    public void displayEmployees() {
        employees.forEach(System.out::println);
    }
}

public class EmployeeClass {
    public static void main(String[] args) {
        EmployeeManagement management = new EmployeeManagement();
        
        management.addEmployee(new Employee(1, "Monish", "Java Developer", 95000));
        management.addEmployee(new Employee(2, "Nikhil", "JFS Developer", 80000));
        management.addEmployee(new Employee(3, "Jagadeesh", "Support Engineer", 75000));
        
        System.out.println("All Employees:");
        management.displayEmployees();
        
        System.out.println("After Sorting by Salary:");
        management.sortEmployeesBySalary();
        management.displayEmployees();
        
        System.out.println("Searching for 'Nikhil':");
        System.out.println(management.searchEmployeeByName("Nikhil"));
        
        System.out.println("Removing Employee with ID 2:");
        management.removeEmployeeById(2);
        management.displayEmployees();
    }
}
