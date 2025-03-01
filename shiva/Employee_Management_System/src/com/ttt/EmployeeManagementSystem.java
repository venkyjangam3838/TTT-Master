package com.ttt;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class EmployeeManagementSystem {
	private List<Employee> employees;
	private Scanner scanner;

	public EmployeeManagementSystem() {
		this.employees = new ArrayList<>();
		this.scanner = new Scanner(System.in);
	}

	public void addEmployee() {
		System.out.print("Enter employee ID: ");
		int id = Integer.parseInt(scanner.nextLine());
		System.out.print("Enter employee name: ");
		String name = scanner.nextLine();
		System.out.print("Enter employee designation: ");
		String designation = scanner.nextLine();
		System.out.print("Enter employee salary: ");
		double salary = Double.parseDouble(scanner.nextLine());

		Employee employee = new Employee(id, name, designation, salary);
		employees.add(employee);
		System.out.println("Employee added successfully!");
	}

	public void removeEmployee() {
		System.out.print("Enter employee ID to remove: ");
		int id = Integer.parseInt(scanner.nextLine());

		employees.removeIf(employee -> employee.getId() == id);
		System.out.println("Employee removed successfully!");
	}

	public void sortEmployeesBySalary() {
		employees.sort(Comparator.comparingDouble(Employee::getSalary));
		System.out.println("Employees sorted by salary successfully!");
	}

	public void searchEmployeeByName() {
		System.out.print("Enter employee name to search: ");
		String name = scanner.nextLine();

		for (Employee employee : employees) {
			if (employee.getName().equals(name)) {
				System.out.println("Employee found!");
				System.out.println("ID: " + employee.getId());
				System.out.println("Name: " + employee.getName());
				System.out.println("Designation: " + employee.getDesignation());
				System.out.println("Salary: " + employee.getSalary());
				return;
			}
		}
		System.out.println("Employee not found!");
	}

	public void displayEmployees() {
		for (Employee employee : employees) {
			System.out.println("ID: " + employee.getId());
			System.out.println("Name: " + employee.getName());
			System.out.println("Designation: " + employee.getDesignation());
			System.out.println("Salary: " + employee.getSalary());
			System.out.println();
		}
	}

	public void run() {
		while (true) {
			System.out.println("1. Add employee");
			System.out.println("2. Remove employee");
			System.out.println("3. Sort employees by salary");
			System.out.println("4. Search employee by name");
			System.out.println("5. Display employees");
			System.out.println("6. Exit");
			System.out.print("Enter your choice: ");
			int choice = Integer.parseInt(scanner.nextLine());

			switch (choice) {
			case 1:
				addEmployee();
				break;
			case 2:
				removeEmployee();
				break;
			case 3:
				sortEmployeesBySalary();
				break;
			case 4:
				searchEmployeeByName();
				break;
			case 5:
				displayEmployees();
				break;
			case 6:
				System.out.println("Exiting...");
				return;
			default:
				System.out.println("Invalid choice. Please try again.");
			}
		}
	}

	public static void main(String[] args) {
		EmployeeManagementSystem ems = new EmployeeManagementSystem();
		ems.run();
	}


}
