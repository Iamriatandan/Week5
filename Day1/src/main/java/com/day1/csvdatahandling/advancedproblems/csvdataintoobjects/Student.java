package com.day1.csvdatahandling.advancedproblems.csvdataintoobjects;

import java.sql.SQLOutput;

public class Student {
    private int id;
    private String name;
    private int rollNumber;
    private String email;
    private String grade;

    public Student(int id, String name, int rollNumber, String email, String grade) {
        this.id = id;
        this.name = name;
        this.rollNumber = rollNumber;
        this.email = email;
        this.grade = grade;
    }

    @Override
    public String toString(){
        return "Student { ID: " + id + ", Name: " + name + ", Email: " +
                email + ", Grade: " + grade + " }";
    }
}
