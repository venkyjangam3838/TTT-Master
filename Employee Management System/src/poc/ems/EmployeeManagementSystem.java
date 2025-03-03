package poc.ems;

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
		return "ID: " + id + ", Name: " + name + ", Designation: " + designation + ", Salary: " + salary;
	}
}

class EmployeeManagement {
	private List<Employee> employees;

	public EmployeeManagement() {
		employees = new ArrayList<>();
	}

	public void addEmployee(Employee employee) {
		employees.add(employee);
	}

	public void removeEmployee(int id) {
		employees.removeIf(emp -> emp.getId() == id);
	}

	public void sortEmployeesBySalary() {
		employees.sort(Comparator.comparingDouble(Employee::getSalary));
	}

	public Employee searchEmployeeByName(String name) {
		for (Employee emp : employees) {
			if (emp.getName().equalsIgnoreCase(name)) {
				return emp;
			}
		}
		return null;
	}

	public void displayEmployees() {
		for (Employee emp : employees) {
			System.out.println(emp);
		}
	}
}

public class EmployeeManagementSystem {
	public static void main(String[] args) {
		EmployeeManagement system = new EmployeeManagement();

		system.addEmployee(new Employee(101, "Ayush", "Manager", 75000));
		system.addEmployee(new Employee(102, "Krishna", "Developer", 60000));
		system.addEmployee(new Employee(103, "Rohit", "Analyst", 50000));

		System.out.println("Employees before sorting:");
		system.displayEmployees();

		system.sortEmployeesBySalary();
		System.out.println("\nEmployees after sorting by salary:");
		system.displayEmployees();

		System.out.println("\nSearching for Krishna:");
		Employee found = system.searchEmployeeByName("Krishna");
		System.out.println(found != null ? found : "Employee not found");

		system.removeEmployee(102);
		System.out.println("\nEmployees after removing Krihsna:");
		system.displayEmployees();
	}
}
