import java.util.*;
import java.io.*;

public class StudentManager {
    private ArrayList<Student> students = new ArrayList<>();

    public StudentManager(List<Student> loadedList) {
        students.addAll(loadedList);
    }

    public void addStudent(Student s) {
        students.add(s);
        System.out.println("Student added!");
    }

    public void viewAll() {
        if (students.isEmpty()) {
            System.out.println("No records found.");
            return;
        }
        Iterator<Student> it = students.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

    public Student searchByName(String name) {
        for (Student s : students) {
            if (s.getName().equalsIgnoreCase(name))
                return s;
        }
        return null;
    }

    public void deleteByName(String name) {
        Iterator<Student> it = students.iterator();

        while (it.hasNext()) {
            if (it.next().getName().equalsIgnoreCase(name)) {
                it.remove();
                System.out.println("Deleted successfully.");
                return;
            }
        }

        System.out.println("Record not found.");
    }

    public void sortByMarks() {
        students.sort(Comparator.comparingDouble(Student::getMarks).reversed());
        System.out.println("Sorted Student List by Marks: ");
        viewAll();
    }

    public List<Student> getList() {
        return students;
    }
}
