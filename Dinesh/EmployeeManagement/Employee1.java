package EmployeeManagement;

import java.util.*;

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
    
    public int getId() { return id; }
    public String getName() { return name; }
    public String getDesignation() { return designation; }
    public double getSalary() { return salary; }

    // To String (for display)
    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Designation: " + designation + ", Salary: $" + salary;
    }
}

class EmployeeManagementSystem {
    private List<Employee> employeeList;

    public EmployeeManagementSystem() {
        employeeList = new ArrayList<>();
    }

    public void addEmployee(int id, String name, String designation, double salary) {
        Employee newEmployee = new Employee(id, name, designation, salary);
        employeeList.add(newEmployee);
        System.out.println("Employee added successfully!");
    }

    public void removeEmployee(int id) {
        boolean removed = employeeList.removeIf(emp -> emp.getId() == id);
        if (removed) {
            System.out.println("Employee with ID " + id + " removed successfully.");
        } else {
            System.out.println("Employee with ID " + id + " not found.");
        }
    }

    // Method to sort employees by salary
    public void sortEmployeesBySalary() {
        employeeList.sort(Comparator.comparingDouble(Employee::getSalary));
        System.out.println("Employees sorted by salary.");
    }

    // Method to search an employee by name
    public void searchEmployeeByName(String name) {
        boolean found = false;
        for (Employee emp : employeeList) {
            if (emp.getName().equalsIgnoreCase(name)) {
                System.out.println(emp);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No employee found with name: " + name);
        }
    }

    // Method to display all employees
    public void displayEmployees() {
        if (employeeList.isEmpty()) {
            System.out.println("No employees found.");
        } else {
            System.out.println("\nEmployee List:");
            for (Employee emp : employeeList) {
                System.out.println(emp);
            }
        }
    }
    public class EmployeeManagementApp {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            EmployeeManagementSystem empSystem = new EmployeeManagementSystem();

            while (true) {
                System.out.println("\n1. Add Employee");
                System.out.println("2. Remove Employee");
                System.out.println("3. Sort Employees by Salary");
                System.out.println("4. Search Employee by Name");
                System.out.println("5. Display All Employees");
                System.out.println("6. Exit");
                System.out.print("Enter your choice: ");

                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        System.out.print("Enter ID: ");
                        int id = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
                        System.out.print("Enter Name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter Designation: ");
                        String designation = scanner.nextLine();
                        System.out.print("Enter Salary: ");
                        double salary = scanner.nextDouble();
                        empSystem.addEmployee(id, name, designation, salary);
                        break;

                    case 2:
                        System.out.print("Enter Employee ID to Remove: ");
                        int removeId = scanner.nextInt();
                        empSystem.removeEmployee(removeId);
                        break;

                    case 3:
                        empSystem.sortEmployeesBySalary();
                        empSystem.displayEmployees();
                        break;

                    case 4:
                        System.out.print("Enter Employee Name to Search: ");
                        String searchName = scanner.nextLine();
                        empSystem.searchEmployeeByName(searchName);
                        break;

                    case 5:
                        empSystem.displayEmployees();
                        break;

                    case 6:
                        System.out.println("Exiting system...");
                        scanner.close();
                        return;

                    default:
                        System.out.println("Invalid choice! Please enter a valid option.");
                }
            }
        }
    }

}

