package com.employeeManagement.in;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


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

public class EmployeeManagementApplication {
    public static void main(String[] args) {
        EmployeeManagement management = new EmployeeManagement();
        
        management.addEmployee(new Employee(1, "Sravani", "Assistant Manager", 45000));
        management.addEmployee(new Employee(2, "Veeraiah", "Manager", 60000));
        management.addEmployee(new Employee(3, "Hemalatha", "Chef", 35000));
        
        System.out.println("All Employees:");
        management.displayEmployees();
        
        System.out.println("\nAfter Sorting by Salary:");
        management.sortEmployeesBySalary();
        management.displayEmployees();
        
        System.out.println("\nSearching for 'Veeraiah':");
        System.out.println(management.searchEmployeeByName("Veeraiah"));
        
        System.out.println("\nRemoving Employee with ID 2:");
        management.removeEmployeeById(2);
        management.displayEmployees();
    }
}
