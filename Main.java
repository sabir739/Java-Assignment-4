import java.util.*;

public class Main {
    public static void main(String[] args) {

        String filename = "students.txt";

        List<Student> loadedStudents = FileUtil.readStudents(filename);
        StudentManager manager = new StudentManager(loadedStudents);

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== Capstone Student Menu =====");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search by Name");
            System.out.println("4. Delete by Name");
            System.out.println("5. Sort by Marks");
            System.out.println("6. Save and Exit");
            System.out.print("Enter choice: ");

            int ch = sc.nextInt();
            sc.nextLine();

            switch (ch) {
                case 1:
                    System.out.print("Enter Roll No: ");
                    int roll = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Email: ");
                    String email = sc.nextLine();

                    System.out.print("Enter Course: ");
                    String course = sc.nextLine();

                    System.out.print("Enter Marks: ");
                    double marks = sc.nextDouble();

                    manager.addStudent(new Student(roll, name, email, course, marks));
                    break;

                case 2:
                    manager.viewAll();
                    break;

                case 3:
                    System.out.print("Enter name: ");
                    String search = sc.nextLine();
                    Student s = manager.searchByName(search);

                    if (s == null) System.out.println("Not found.");
                    else System.out.println(s);
                    break;

                case 4:
                    System.out.print("Enter name to delete: ");
                    String del = sc.nextLine();
                    manager.deleteByName(del);
                    break;

                case 5:
                    manager.sortByMarks();
                    break;

                case 6:
                    FileUtil.writeStudents(filename, manager.getList());
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
