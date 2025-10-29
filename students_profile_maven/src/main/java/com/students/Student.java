package com.students;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import java.sql.Date;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @Column(name = "student_id")
    private String studentId;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;
    
    @Column(name = "program")
    private String program;

    @Column(name = "registration_date")
    private Date registrationDate;

    @Column(name = "last_updated_date")
    private Date lastUpdated;

    public Date getLastUpdated() {
        return lastUpdated;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "roll_number")
    private Address address;

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public Student() {
    }

    public Student(String studentId, String name, int age, String program, Date registrationDate){
        this.studentId = studentId;
        this.name = name;
        this.age = age;
        this.program = program;
        this.registrationDate = registrationDate;
    }

    public void printProfile(){
        System.out.println("Student ID: " + studentId + "\n" +
                "Name: " + name + "\n" +
                "Age: " + age + "\n" +
                "Program: " + program + "\n" + "Registration Date: " + registrationDate + "\n" +
                "----------------------------------------------------");
    }
    public void printUpdatedProfile(){
        System.out.println("Student ID: " + studentId + "\n" +
                "Name: " + name + "\n" +
                "Age: " + age + "\n" +
                "Program: " + program + "\n" + "Registration Date: " + registrationDate + "\n" +
                "Last Updated Date: " + lastUpdated + "\n" +
                "----------------------------------------------------");
    }
}
