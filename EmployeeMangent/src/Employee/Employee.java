package Employee;

import java.util.Objects;

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

    // Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public String getDesignation() { return designation; }
    public double getSalary() { return salary; }

    @Override
    public String toString() {
        return "Employee{id=" + id + ", name='" + name + "', designation='" + designation + "', salary=" + salary + "}";
    }

    // Override equals and hashCode for correct comparisons
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Employee employee = (Employee) obj;
        return id == employee.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
