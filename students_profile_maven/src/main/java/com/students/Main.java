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
                case 2 -> student.viewAllStudents();
                case 3 -> {
                    System.out.println("Exiting program. Goodbye!");
                    running = false;
                }
                default -> System.out.println("Invalid choice, try again.");
            }
        }

    }
}