package Employee;

import java.util.Scanner;

public class Employee0 {
    public static void main(String[] args) {
        EmployeeManagement management = new EmployeeManagement();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nEmployee Management System");
            System.out.println("1. Add Employee");
            System.out.println("2. Remove Employee");
            System.out.println("3. Display Employees");
            System.out.println("4. Sort Employees by Salary");
            System.out.println("5. Search Employee by Name");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1: // Add Employee
                    System.out.print("Enter Employee ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    System.out.print("Enter Employee Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter Designation: ");
                    String designation = scanner.nextLine();

                    System.out.print("Enter Salary: ");
                    double salary = scanner.nextDouble();

                    management.addEmployee(new Employee(id, name, designation, salary));
                    System.out.println("Employee added successfully!");
                    break;

                case 2: // Remove Employee
                    System.out.print("Enter Employee ID to Remove: ");
                    int removeId = scanner.nextInt();

                    if (management.removeEmployeeById(removeId)) {
                        System.out.println("Employee removed successfully!");
                    } else {
                        System.out.println("Employee not found!");
                    }
                    break;

                case 3: // Display Employees
                    System.out.println("\nEmployee List:");
                    management.displayEmployees();
                    break;

                case 4: // Sort Employees
                    management.sortEmployeesBySalary();
                    System.out.println("Employees sorted by salary!");
                    break;

                case 5: // Search Employee
                    System.out.print("Enter Employee Name to Search: ");
                    String searchName = scanner.nextLine();

                    management.searchEmployeeByName(searchName)
                            .ifPresentOrElse(
                                    emp -> System.out.println("Employee Found: " + emp),
                                    () -> System.out.println("Employee not found!")
                            );
                    break;

                case 6: // Exit
                    System.out.println("Exiting Employee Management System...");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}

