import java.util.ArrayList;
import java.util.Scanner;

class studentManager {
    public Scanner scanner = new Scanner(System.in);
    public ArrayList<Student> students = new ArrayList<>();

    public void printMenu() {
        System.out.println("\n--- Student Profile Manager ---");
        System.out.println("1. Add new student profile");
        System.out.println("2. View all student profiles");
        System.out.println("3. Exit");
    }

    public void addStudent() {
        String name = InputValidator.getStringInput("Enter Name: ");
        int age = InputValidator.getIntInput("Enter Age: ");

        System.out.println("Enter Student ID: ");
        String studentId = scanner.nextLine();

        String program = InputValidator.getStringInput("Enter Program:");

        Student newStudent = new Student(name, age, studentId, program);
        students.add(newStudent);
        System.out.println("Student profile added successfully!");
    }

    public void viewAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No student profiles to display.");
            return;
        }
        System.out.println("\n--- All Student Profiles ---");
        for (Student s : students) {
            s.printProfile();
        }
    }
}
