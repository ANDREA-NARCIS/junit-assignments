package com.assignment;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MultiStudentGradeManagerTest {

    @Test
    void multipleStudentsHandledIndependently() {
        MultiStudentGradeManager manager = new MultiStudentGradeManager();

        manager.addStudent("A");
        manager.addStudent("B");

        manager.addMarks("A", 30);
        manager.addMarks("B", 80);

        assertEquals("FAIL", manager.getResult("A"));
        assertEquals("PASS", manager.getResult("B"));
    }

    @Test
    void topperIsCalculatedCorrectly() {
        MultiStudentGradeManager manager = new MultiStudentGradeManager();

        manager.addStudent("A");
        manager.addStudent("B");

        manager.addMarks("A", 60);
        manager.addMarks("B", 90);

        assertEquals("B", manager.getTopper());
    }

    @Test
    void addingMarksToInvalidStudentThrowsException() {
        MultiStudentGradeManager manager = new MultiStudentGradeManager();

        assertThrows(IllegalArgumentException.class,
                () -> manager.addMarks("X", 50));
    }

    @Test
    void noStudentsThrowsException() {
        MultiStudentGradeManager manager = new MultiStudentGradeManager();

        assertThrows(IllegalStateException.class,
                () -> manager.getTopper());
    }
}