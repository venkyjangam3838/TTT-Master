package Employee;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class EmployeeManagement {
    private List<Employee> employees = new ArrayList<>();

    // Add Employee
    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    // Remove Employee by ID
    public boolean removeEmployeeById(int id) {
        return employees.removeIf(emp -> emp.getId() == id);
    }

    // Sort Employees by Salary (Ascending Order)
    public void sortEmployeesBySalary() {
        employees.sort(Comparator.comparingDouble(Employee::getSalary));
    }

    // Search Employee by Name (Case Insensitive)
    public Optional<Employee> searchEmployeeByName(String name) {
        return employees.stream()
                .filter(emp -> emp.getName().equalsIgnoreCase(name))
                .findFirst();
    }

    // Display All Employees
    public void displayEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employees found.");
        } else {
            employees.forEach(System.out::println);
        }
    }
}

