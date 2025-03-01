package Student;
import java.util.*;

class StudentMarksManagement {
 private Map<String, List<Integer>> studentMarks;

 public StudentMarksManagement() {
     studentMarks = new HashMap<>();
 }

 public void addMarks(String studentName, int mark) {
     studentMarks.computeIfAbsent(studentName, k -> new ArrayList<>()).add(mark);
 }

 public double calculateAverage(String studentName) {
     List<Integer> marks = studentMarks.get(studentName);
     if (marks == null || marks.isEmpty()) {
         System.out.println("No marks found for " + studentName);
         return 0.0;
     }
     return marks.stream().mapToInt(Integer::intValue).average().orElse(0.0);
 }

 public void displayAllStudents() {
     for (Map.Entry<String, List<Integer>> entry : studentMarks.entrySet()) {
         System.out.println("Student: " + entry.getKey() + " | Marks: " + entry.getValue());
     }
 }
}

public class StudentManagementSystem {
 public static void main(String[] args) {
     StudentMarksManagement smm = new StudentMarksManagement();
     smm.addMarks("Pooja", 85);
     smm.addMarks("Prathyusha", 90);
     smm.addMarks("lavnya", 78);
     smm.addMarks("Vidhya", 82);
     smm.addMarks("shilpa", 95);

     System.out.println("\nAll Students and Marks:");
     smm.displayAllStudents();

     System.out.println("\nAverage Marks:");
     System.out.println("Pooja: " + smm.calculateAverage("Pooja"));
     System.out.println("lavnya: " + smm.calculateAverage("lavnya"));
     System.out.println("shilpa: " + smm.calculateAverage("shilpa"));
}
}
