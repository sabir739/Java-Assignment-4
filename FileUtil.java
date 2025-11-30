import java.io.*;
import java.util.*;

public class FileUtil {

    public static List<Student> readStudents(String filename) {
        List<Student> list = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                int roll = Integer.parseInt(data[0]);
                String name = data[1];
                String email = data[2];
                String course = data[3];
                double marks = Double.parseDouble(data[4]);

                list.add(new Student(roll, name, email, course, marks));
            }

            System.out.println("Loaded students from file:");
        } catch (Exception e) {
            System.out.println("File not found. Creating a new one...");
        }

        return list;
    }

    public static void writeStudents(String filename, List<Student> list) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {

            for (Student s : list) {
                bw.write(s.getRollNo() + "," + s.getName() + "," + s.getEmail() + "," +
                         s.getCourse() + "," + s.getMarks());
                bw.newLine();
            }

            System.out.println("Saved successfully!");
        } catch (Exception e) {
            System.out.println("Error writing to file!");
        }
    }
}
