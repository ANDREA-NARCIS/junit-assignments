import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

public class StudentGradeParameterizedTest {

    // 1. Verify adding valid positive marks does not throw exception
    @ParameterizedTest
    @ValueSource(ints = {10, 40, 75, 100})
    void testAddValidMarksDoesNotThrow(int mark) {
        StudentGradeParameterized calc = new StudentGradeParameterized();
        assertDoesNotThrow(() -> calc.addMarks(mark));
    }

    // 2. Test multiple sets of marks and expected averages
    @ParameterizedTest
    @CsvSource({
            "40, 60, 50",
            "30, 50, 40",
            "80, 90, 85"
    })
    void testCalculateAverage(int m1, int m2, double expectedAverage) {
        StudentGradeParameterized calc = new StudentGradeParameterized();
        calc.addMarks(m1);
        calc.addMarks(m2);
        assertEquals(expectedAverage, calc.calculateAverage());
    }

    // 3. Test PASS / FAIL results
    @ParameterizedTest
    @CsvSource({
            "50, 60, PASS",
            "30, 35, FAIL",
            "40, 40, PASS"
    })
    void testResult(int m1, int m2, String expectedResult) {
        StudentGradeParameterized calc = new StudentGradeParameterized();
        calc.addMarks(m1);
        calc.addMarks(m2);
        assertEquals(expectedResult, calc.getResult());
    }

    // 4. Confirm negative marks throw exception
    @ParameterizedTest
    @ValueSource(ints = {-1, -10, -100})
    void testNegativeMarksThrowsException(int mark) {
        StudentGradeParameterized calc = new StudentGradeParameterized();
        assertThrows(IllegalArgumentException.class, () -> calc.addMarks(mark));
    }

    // 5. Complex test data using MethodSource
    @ParameterizedTest
    @MethodSource("provideMarksAndAverage")
    void testMultipleMarksAverage(List<Integer> marks, double expectedAverage) {
        StudentGradeParameterized calc = new StudentGradeParameterized();
        marks.forEach(calc::addMarks);
        assertEquals(expectedAverage, calc.calculateAverage());
    }

    static Stream<Object[]> provideMarksAndAverage() {
        return Stream.of(
                new Object[]{List.of(40, 50, 60), 50.0},
                new Object[]{List.of(30, 30, 30), 30.0},
                new Object[]{List.of(80, 90, 100), 90.0}
        );
    }

    // Extra: No marks exception
    @Test
    void testNoMarksThrowsException() {
        StudentGradeParameterized calc = new StudentGradeParameterized();
        assertThrows(IllegalStateException.class, calc::calculateAverage);
    }
}