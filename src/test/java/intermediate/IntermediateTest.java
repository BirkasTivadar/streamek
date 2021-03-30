package intermediate;

import org.junit.jupiter.api.Test;


import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class IntermediateTest {

    List<Employee> employees = Arrays.asList(
            new Employee("John Doe"),
            new Employee("Jane Doe"),
            new Employee("Joe Doe"),
            new Employee("John Smith")
    );

    @Test
    void testFilter() {
        List<Employee> filtered = employees.stream().filter(f -> f.getName().startsWith("John")).collect(Collectors.toList());
        assertEquals(2, filtered.size());
        assertEquals("John Doe", filtered.get(0).getName());
    }

    @Test
    void testDistinct() {
        List<String> filtered = Stream.of("John", "John", "Jane", "John").distinct().collect(Collectors.toList());
        assertEquals(2, filtered.size());
        assertEquals(Arrays.asList("John", "Jane"), filtered);
    }

    @Test
    void testLimitSkip() {
        List<Employee> filtered = employees.stream().skip(1).limit(2).collect(Collectors.toList());
        assertEquals(2, filtered.size());
        assertEquals("Joe Doe", filtered.get(1).getName());
    }

    @Test
    void testInfinitive() {
        List<Double> nums = Stream.generate(Math::random).limit(5).collect(Collectors.toList());
        List<Integer> numbers = Stream.iterate(1, i -> i + 2).skip(2).limit(3).collect(Collectors.toList());

        assertEquals(5, nums.size());
        assertEquals(Arrays.asList(5, 7, 9), numbers);
    }

    @Test
    void testMap() {
        List<String> names = employees.stream().map(e -> e.getName()).limit(2).collect(Collectors.toList());
        assertEquals(Arrays.asList("John Doe", "Jane Doe"), names);
    }

    @Test
    void testFlatMap() {
        List<String> s1 = Arrays.asList("John Doe", "Jane Doe");
        List<String> s2 = Arrays.asList("Jack Doe", "Joe Doe");

        List<String> s = Stream.of(s1, s2).flatMap(l -> l.stream()).collect(Collectors.toList());
        assertEquals(Arrays.asList("John Doe", "Jane Doe", "Jack Doe", "Joe Doe"), s);
    }

    @Test
    void testSorted() {
        List<Employee> sorted = employees.stream().sorted(Comparator.comparing(Employee::getName)).collect(Collectors.toList());
        System.out.println(sorted);
        assertEquals(4, sorted.size());
        assertEquals("Jane Doe", sorted.get(0).getName());
    }

    @Test
    void testPeek() {
        List<String> s = employees.stream()
                .peek(System.out::println)
                .map(Employee::getName)
                .peek(System.out::println)
                .sorted()
                .peek(System.out::println)
                .limit(2)
                .collect(Collectors.toList());

        System.out.println(s);
    }

}