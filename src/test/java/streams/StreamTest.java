package streams;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class StreamTest {

    List<Employee> employees = Arrays.asList(
            new Employee("John Doe"),
            new Employee("Jane Doe"),
            new Employee("Joe Doe"),
            new Employee("John Smith")
    );

    @Test
    void testCount() {
        assertEquals(0, Stream.empty().count());

        assertEquals(2, Stream.of(new Employee("John Doe"), new Employee("Jack Doe")).count());

        Stream<Employee> s = Stream.of(new Employee("John Doe"), new Employee("Jack Doe"));
        assertEquals(2, s.count());

        assertEquals(4, employees.stream().count());
    }

    @Test
    void testMin() {
        Employee employee = employees.stream().min(Comparator.comparing(Employee::getName)).get();
        assertEquals("Jane Doe", employee.getName());
    }

    @Test
    void testFindFirst() {
        Employee employee = employees.stream().findFirst().get();
        assertEquals("John Doe", employee.getName());
    }

    @Test
    void testAllMatch() {
        assertTrue(employees.stream().allMatch(e -> e.getName().length() > 5));

        assertFalse(employees.stream().allMatch(e -> e.getName().startsWith("a")));
    }

    @Test
    void testForEach() {
        employees.forEach(System.out::println);
        employees.forEach(e -> e.setName(e.getName().toUpperCase()));
        employees.forEach(System.out::println);
        assertEquals("JOHN DOE", employees.get(0).getName());
    }

}