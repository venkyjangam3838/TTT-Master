package com.learn.poc;

public class EmployeeRunner {

	public static void main(String[] args) {
	
		
		    EmployeeManagementSystem system = new EmployeeManagementSystem();
		        
		  system.addEmployee(new Employee(1, "Alice", "Manager", 75000));
		        system.addEmployee(new Employee(2, "Bob", "Developer", 60000));
		        system.addEmployee(new Employee(3, "Charlie", "Designer", 55000));
		        
		        system.displayEmployees();
		        
		        system.sortEmployeesBySalary();
		        system.displayEmployees();
		        
		        Employee searchResult = system.searchEmployeeByName("Bob");
		        System.out.println(searchResult != null ? "Found: " + searchResult : "Employee not found");
		        
		        system.removeEmployee(2);
		        system.displayEmployees();
		    





}

}
