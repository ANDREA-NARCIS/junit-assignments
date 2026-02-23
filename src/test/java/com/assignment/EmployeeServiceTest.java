import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import org.junit.jupiter.api.Test;

public class EmployeeServiceTest {

    EmployeeService service = new EmployeeService();

    // 1. Verify employees with salary > 50,000 are filtered
    @Test
    void testEmployeesWithSalaryGreaterThan50000() {
        List<Employee> employees = List.of(
                new Employee("Alice", 60000),
                new Employee("Bob", 45000),
                new Employee("Charlie", 70000)
        );

        List<String> result = service.getEmployeesWithHighSalary(employees);

        assertEquals(2, result.size());
        assertTrue(result.contains("Alice"));
        assertTrue(result.contains("Charlie"));
    }

    // 2. Ensure employees with salary ≤ 50,000 are excluded
    @Test
    void testEmployeesWithSalaryLessThanOrEqual50000Excluded() {
        List<Employee> employees = List.of(
                new Employee("Bob", 50000),
                new Employee("Tom", 30000)
        );

        List<String> result = service.getEmployeesWithHighSalary(employees);

        assertTrue(result.isEmpty());
    }

    // 3. Check returned list contains only names
    @Test
    void testReturnedListContainsOnlyNames() {
        List<Employee> employees = List.of(
                new Employee("Alice", 60000)
        );

        List<String> result = service.getEmployeesWithHighSalary(employees);

        assertEquals(String.class, result.get(0).getClass());
    }

    // 4. Verify behavior when employee list is empty
    @Test
    void testEmptyEmployeeList() {
        List<Employee> employees = List.of();

        List<String> result = service.getEmployeesWithHighSalary(employees);

        assertTrue(result.isEmpty());
    }

    // 5. Verify behavior when all employees meet condition
    @Test
    void testAllEmployeesMeetSalaryCondition() {
        List<Employee> employees = List.of(
                new Employee("Alice", 60000),
                new Employee("Charlie", 80000)
        );

        List<String> result = service.getEmployeesWithHighSalary(employees);

        assertEquals(2, result.size());
    }
}