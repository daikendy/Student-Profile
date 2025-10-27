package com.students;

import java.util.List;
import java.util.Scanner;
import org.hibernate.Session;

class studentManager {
    public Scanner scanner = new Scanner(System.in);

    public void printMenu() {
        System.out.println("\n--- Student Profile Manager ---");
        System.out.println("1. Add new student profile");
        System.out.println("2. View student profile");
        System.out.println("3. Update student profile");
        System.out.println("4. Delete student profile");
        System.out.println("5. View all student profiles");
        System.out.println("6. Exit");
    }

    public void addStudent() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        System.out.println();

        System.out.println("Enter Student ID: ");
        String studentId = scanner.nextLine();

        // Check for existing Student ID
        Student existingStudent = session.get(Student.class, studentId);
        if (existingStudent != null) {
            System.out.println("A student with ID " + studentId + " already exists. Please use a different ID.");
            session.getTransaction().rollback();
            session.close();
            return;
        }

        String name = InputValidator.getStringInput("Enter Name: ");
        int age = InputValidator.getIntInput("Enter Age: ");

        String program = InputValidator.getStringInput("Enter Program:");
        
        System.out.println();
        Student newStudent = new Student(studentId, name, age, program,  new java.sql.Date(System.currentTimeMillis()));  
        session.persist(newStudent);
        session.getTransaction().commit();
        System.out.println();
        System.out.println("-----Successfully added student profile-----");
        newStudent.printProfile();
        session.close();
    }

    public void studentInfo() {
        // Implementation for viewing a specific student's info
        String studentId = InputValidator.getStringInput("Enter Student ID to view: ");
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Student student = session.get(Student.class, studentId);
            if (student != null) {
                System.out.println("\n--- Student Profile ---");
                student.printProfile();
            } else {
                System.out.println();
                System.out.println("Student with ID " + studentId + " not found.");
            }
        } catch (Exception e) {
            System.out.println("Error retrieving student profile: " + e.getMessage());
        }
    }

    public void updateStudent() {
        // Implementation for updating a student's info
        String studentId = InputValidator.getStringInput("Enter Student ID to update: ");

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Student student = session.get(Student.class, studentId);
            if (student != null) {
                System.out.println("\n--- Update Student Profile ---");
                student.printProfile();

                String newName = InputValidator.getBlankStringInput("Enter new Name (leave blank to keep unchanged): ");
                if (!newName.isBlank()) {
                    student.setName(newName);
                }

                int newAge = InputValidator.getBlankIntInput("Enter new Age (leave blank to keep unchanged): ");
                if (newAge != -1) {
                    student.setAge(newAge);
                }

                String newProgram = InputValidator.getBlankStringInput("Enter new Program (leave blank to keep unchanged): ");
                if (!newProgram.isBlank()) {
                    student.setProgram(newProgram);
                }

                System.out.println();
                session.beginTransaction();
                System.out.println();

                session.merge(student);
                session.getTransaction().commit();
                System.out.println();

                System.out.println("------Student profile updated successfully------");
                student.printProfile();

            } else {
                System.out.println();
                System.out.println("Student with ID " + studentId + " not found.");
            }
        } catch (Exception e) {
            System.out.println("Error updating student profile: " + e.getMessage());
        }
    }

    public void deleteStudent() {
        // Implementation for deleting a student's info
        String studentId = InputValidator.getStringInput("Enter Student ID to delete: ");

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Student student = session.get(Student.class, studentId);
            if (student != null) {
                System.out.println("\n--- Delete Student Profile ---");
                student.printProfile();

                String confirmation = InputValidator.getStringInput("Are you sure you want to delete this profile? (yes/no): ");
                if (confirmation.equalsIgnoreCase("yes")) {
                    session.beginTransaction();
                    session.remove(student);
                    session.getTransaction().commit();
                    System.out.println();
                    System.out.println("Student profile deleted successfully.");
                } else {
                    System.out.println("Deletion cancelled.");
                }
            } else {
                System.out.println();
                System.out.println("Student with ID " + studentId + " not found.");
            }
        } catch (Exception e) {
            System.out.println("Error deleting student profile: " + e.getMessage());
        }
    }

public void viewAllStudents() {
    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
        List<Student> studentList = session.createQuery("from Student", Student.class).list();

        if (studentList.isEmpty()) {
            System.out.println("No student profiles found in the database.");
        } else {
            System.out.println("\n--- All Student Profiles ---");
            for (Student s : studentList) {
                s.printProfile();
            }
        }
    } catch (Exception e) {
        System.out.println("Error retrieving student profiles: " + e.getMessage());
    }
}

}