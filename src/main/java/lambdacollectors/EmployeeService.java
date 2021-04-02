package lambdacollectors;

import java.util.*;
import java.util.stream.Collectors;

public class EmployeeService {

    public String concatenateNames(List<Employee> employees) {
        return employees.stream().map(e -> e.getName()).collect(Collectors.joining(", "));
    }

    public long sumSalaries(List<Employee> employees) {
//        return employees.stream().mapToInt(e -> e.getSalary()).sum();
//        return employees.stream().collect(Collectors.summingInt(Employee::getSalary));
        return employees.stream()
                .collect(Collectors.summarizingInt(Employee::getSalary)).getSum();
    }

    public List<Employee> filterSalaryGreaterThan(List<Employee> employees, int minSalary) {
        return employees.stream().filter(e -> e.getSalary() >= minSalary).collect(Collectors.toList());
    }

    public Map<Long, Employee> groupById(List<Employee> employees) {
        return employees.stream().collect(Collectors.toMap(Employee::getId, e -> e));

    }

    public Map<String, List<Employee>> groupByDivision(List<Employee> employees) {
        return employees.stream().collect(Collectors.groupingBy(Employee::getDivision));
    }

    public Map<String, Long> noEmployeesPerDivision(List<Employee> employees) {
        return employees.stream().collect(Collectors.groupingBy(Employee::getDivision, Collectors.counting()));
    }

    public Map<Boolean, List<Employee>> partitionBySalary(List<Employee> employees, long minSalary) {
        return employees.stream().collect(Collectors.partitioningBy(e -> e.getSalary() >= minSalary));
    }

    public Map<String, Optional<Integer>> minSalaryByDivision(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getDivision,
                        Collectors.mapping(Employee::getSalary,
                                Collectors.minBy(Comparator.naturalOrder()))));
    }
}
