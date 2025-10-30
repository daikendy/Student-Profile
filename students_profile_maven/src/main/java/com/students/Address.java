package com.students;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "addresses")
public class Address {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "roll_number")
  private long rollId;
  private String city;
  private String province;
  private String state;

  @OneToOne(mappedBy = "address")
  private Student student;

  // Getters and setters

  public Student getStudent() {
    return student;
  }
  public void setStudent(Student student) {
    this.student = student;
  }
  public long getRollId() {
    return rollId;
  }
  public void setRollId(long rollId) {
    this.rollId = rollId;
  }
  public String getCity() {
    return city;
  }
  public void setCity(String city) {
    this.city = city;
  }
  public String getProvince() {
    return province;
  }
  public void setProvince(String province) {
    this.province = province;
  }
  public String getState() {
    return state;
  }
  public void setState(String state) {
    this.state = state;
  }

  public Address() {}
  public Address(long rollId, String city, String province, String state) {
    this.rollId = rollId;
    this.city = city;
    this.province = province;
    this.state = state;
  }

  public void displayAddress() {
    System.out.println("------Updated Address Details:------");
    System.out.println("City: " + city);
    System.out.println("Province: " + province);
    System.out.println("State: " + state);
    System.out.println("----------------------------------------------------");
  }
}
