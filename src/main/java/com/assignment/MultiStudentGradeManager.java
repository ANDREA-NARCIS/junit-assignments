package com.assignment;

import java.util.*;

public class MultiStudentGradeManager {

    private Map<String, StudentGradeCalculator> students = new HashMap<>();

    public void addStudent(String name) {
        students.put(name, new StudentGradeCalculator());
    }

    public void addMarks(String name, int marks) {
        if (!students.containsKey(name)) {
            throw new IllegalArgumentException("Student not found");
        }
        students.get(name).addMarks(marks);
    }

    public double calculateAverage(String name) {
        return students.get(name).calculateAverage();
    }

    public String getResult(String name) {
        return students.get(name).getResult();
    }

    public String getTopper() {
        if (students.isEmpty()) {
            throw new IllegalStateException("No students added");
        }

        return students.entrySet()
                .stream()
                .max(Comparator.comparingDouble(
                        e -> e.getValue().calculateAverage()))
                .get()
                .getKey();
    }
}