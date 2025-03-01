package StudentAll;

import java.util.*;

public class StudentAll {
    private HashMap<String, List<Integer>> studentMarks;

    public StudentAll() {
        studentMarks = new HashMap<>();
    }

   
    public void addMarks(String studentName, int mark) {
        if (!studentMarks.containsKey(studentName)) {
            studentMarks.put(studentName, new ArrayList<>());
        }
        studentMarks.get(studentName).add(mark);
    }

    
    public double calculateAverageMarks(String studentName) {
        if (!studentMarks.containsKey(studentName)) {
            return 0.0;
        }
        List<Integer> marks = studentMarks.get(studentName);
        int totalMarks = 0;
        for (int mark : marks) {
            totalMarks += mark;
        }
        return (double) totalMarks / marks.size();
    }

    
    public void displayAllStudentData() {
        Iterator<Map.Entry<String, List<Integer>>> iterator = studentMarks.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, List<Integer>> entry = iterator.next();
            String studentName = entry.getKey();
            List<Integer> marks = entry.getValue();
            System.out.println("Student Name: " + studentName);
            System.out.println("Marks: " + marks);
            System.out.println("Average Marks: " + calculateAverageMarks(studentName));
            System.out.println("-----------------------------");
        }
    }
    
    public static void main(String[] args) {
        StudentAll system = new StudentAll();

        
        system.addMarks("Monish", 95);
        system.addMarks("Nikhil", 90);
        system.addMarks("Monish", 95);
        system.addMarks("Monish", 90);
        system.addMarks("Nikhil", 93);

       
        system.displayAllStudentData();
    }
}
