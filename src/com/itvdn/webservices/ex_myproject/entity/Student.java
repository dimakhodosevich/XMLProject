package com.itvdn.webservices.ex_myproject.entity;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private String lastName;
    private double averageScore;
    private int course;
    private List<String> subjects;

    public Student() {
        subjects = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(double averageScore) {
        this.averageScore = averageScore;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public List<String> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<String> subjects) {
        this.subjects = subjects;
    }

    @Override
    public String toString() {
        return "Student: " + name + " " + lastName + " studies on " + course
                + ", average score = " + averageScore
                + " has favorite subject(s): " + subjects + "\n";
    }
}
