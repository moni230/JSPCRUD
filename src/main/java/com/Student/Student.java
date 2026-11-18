package com.Student;

// the Entity class, contains the student information details.
public class Student {

    private int id;
    private String name;
    private String phoneNumber;
    private String gender;
    private String department;

    // constructor to initialize the object.
    public Student() {

    }

    // parameterized constructor
    public Student(int id, String name, String phoneNumber, String gender, String department) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.department = department;
    }

    // get & set methods, to set the values and get the values for respective db columns.
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
