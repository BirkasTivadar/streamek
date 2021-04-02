package primitivestreams;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeServiceTest {

    private List<Employee> employees = Collections.unmodifiableList(Arrays.asList(
            new Employee("John Doe", 180_000, null),
            new Employee("Jane Doe", 200_000, "bbb-123"),
            new Employee("Joe Doe", 100_000, null),
            new Employee("John Smith", 100_000, "aaa-123")));

    private EmployeeService employeeService = new EmployeeService();

    @Test
    void testGenerateEmployees() {
        List<Employee> generated = employeeService.generateEmployees("John Doe", 3);
        assertEquals(Arrays.asList("John Doe 0", "John Doe 1", "John Doe 2"),
                generated.stream().map(Employee::getName).collect(Collectors.toList()));
    }

    @Test
    void testSumSalary() {
        assertEquals(580_000, employeeService.sumSalary(employees));
    }

    @Test
    void testSalaryBoundaries() {
        assertEquals(100_000, employeeService.salaryBoundaries(employees).getMin());
        assertEquals(200_000, employeeService.salaryBoundaries(employees).getMax());
    }
}