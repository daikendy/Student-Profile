package com.students;

import java.util.List;
import java.util.Scanner;
import org.hibernate.Session;

class studentManager {
    public Scanner scanner = new Scanner(System.in);

    public void printMenu() {
        System.out.println("\n--- Student Profile Manager ---");
        System.out.println("1. Add new student profile");
        System.out.println("2. View all student profiles");
        System.out.println("3. Exit");
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
        Student newStudent = new Student(studentId, name, age, program);  
        System.out.println("----------------------------------------");
        System.out.println("Successfully added student profile:");
        System.out.println("----------------------------------------");
        System.out.println();
        session.persist(newStudent);
        session.getTransaction().commit();
        session.close();
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