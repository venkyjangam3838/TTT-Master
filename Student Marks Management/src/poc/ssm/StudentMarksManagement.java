package poc.ssm;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentMarksManagement {
	private Map<String, List<Integer>> studentMarks;

	public StudentMarksManagement() {
		studentMarks = new HashMap<>();
	}

	public void addMarks(String studentName, int mark) {
		studentMarks.computeIfAbsent(studentName, _ -> new ArrayList<>()).add(mark);
	}

	public double getAverageMarks(String studentName) {
		List<Integer> marks = studentMarks.get(studentName);
		if (marks == null || marks.isEmpty()) {
			System.out.println("No marks found for " + studentName);
			return 0.0;
		}
		int sum = marks.stream().mapToInt(Integer::intValue).sum();
		return (double) sum / marks.size();
	}

	public void displayAllStudents() {
		if (studentMarks.isEmpty()) {
			System.out.println("No student data available.");
			return;
		}
		for (Map.Entry<String, List<Integer>> entry : studentMarks.entrySet()) {
			System.out.println("Student: " + entry.getKey() + " | Marks: " + entry.getValue());
		}
	}

	public static void main(String[] args) {
		StudentMarksManagement system = new StudentMarksManagement();

		system.addMarks("Venky", 85);
		system.addMarks("Satish", 90);
		system.addMarks("Vicky", 78);
		system.addMarks("Mohan", 88);
		system.addMarks("Vijay", 92);

		System.out.println("Average marks of Venky: " + system.getAverageMarks("Venky"));
		System.out.println("Average marks of Vicky: " + system.getAverageMarks("Vicky"));
		System.out.println("Average marks of Vijay: " + system.getAverageMarks("Vijay"));

		System.out.println("\nAll Student Data:");
		system.displayAllStudents();
	}
}