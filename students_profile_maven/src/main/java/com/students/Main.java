package com.students;

public class Main {
    public static void main( String[] args ) {
        studentManager student = new studentManager();
        boolean running = true;
        while (running) {
            student.printMenu();
            int choice = InputValidator.getIntInput("Enter your choice: ");

            switch (choice) {
                case 1 -> student.addStudent();
                case 2 -> student.studentInfo();
                case 3 -> student.updateStudent();
                case 4 -> student.deleteStudent();
                case 5 -> student.viewAllStudents();
                case 6 -> {
                    System.out.println("Exiting program. Goodbye!");
                    running = false;
                }
                default -> System.out.println("Invalid choice, try again.");
            }
        }

    }
}