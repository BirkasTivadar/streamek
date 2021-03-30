package streams;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

public class ReduceTest {

    List<Employee> employees = Arrays.asList(
            new Employee("John Doe"),
            new Employee("Jane Doe"),
            new Employee("Joe Doe"),
            new Employee("John John Smith")
    );

    @Test
    void testReduce() {
        int lentgh = employees.stream().reduce(0,
                (i, e) -> i + e.getName().length(),
                Integer::sum);
        // System.out.println(lentgh);
        assertEquals(38, lentgh);
    }

    @Test
    void testNameCounter() {
        NameCounter nameCounter = employees.stream().reduce(new NameCounter(),
                (nc, e) -> nc.add(e),
                (nc1, nc2) -> nc1.add(nc2));

        assertEquals(1, nameCounter.getThreePartName());
        assertEquals(3, nameCounter.getTwoPartName());
    }

    @Test
    void testNameCounterCollect() {
        NameCounterMod nameCounterMod = employees.stream().collect(NameCounterMod::new,
                (ncm, employee) -> ncm.add(employee),
                (ncm1, ncm2) -> ncm1.add(ncm2));
        assertEquals(1, nameCounterMod.getThreePartName());
        assertEquals(3, nameCounterMod.getTwoPartName());
    }
}
