package com.assignment;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentGradeCalculatorTest {

    StudentGradeCalculator calculator;

    @BeforeEach
    void setup() {
        calculator = new StudentGradeCalculator();
    }

    @Test
    void averageCalculatedCorrectly() {
        calculator.addMarks(50);
        calculator.addMarks(70);
        assertEquals(60, calculator.calculateAverage());
    }

    @Test
    void passWhenAverageAbove40() {
        calculator.addMarks(60);
        assertEquals("PASS", calculator.getResult());
    }

    @Test
    void failWhenAverageBelow40() {
        calculator.addMarks(30);
        assertEquals("FAIL", calculator.getResult());
    }

    @Test
    void negativeMarksThrowsException() {
        assertThrows(IllegalArgumentException.class,
                () -> calculator.addMarks(-10));
    }

    @Test
    void noMarksThrowsException() {
        assertThrows(IllegalStateException.class,
                () -> calculator.calculateAverage());
    }
}