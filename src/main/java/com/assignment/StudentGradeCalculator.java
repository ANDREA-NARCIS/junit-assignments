package com.assignment;

import java.util.ArrayList;
import java.util.List;

public class StudentGradeCalculator {

    private List<Integer> marks = new ArrayList<>();

    public void addMarks(int marks) {
        if (marks < 0) {
            throw new IllegalArgumentException("Negative marks not allowed");
        }
        this.marks.add(marks);
    }

    public double calculateAverage() {
        if (marks.isEmpty()) {
            throw new IllegalStateException("No marks added");
        }
        return marks.stream().mapToInt(Integer::intValue).average().getAsDouble();
    }

    public String getResult() {
        return calculateAverage() >= 40 ? "PASS" : "FAIL";
    }
}