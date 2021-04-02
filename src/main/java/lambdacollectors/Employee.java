package lambdacollectors;

public class Employee {
    private long id;
    private String name;
    private int salary;
    private String division;

    public Employee(long id, String name, int salary, String division) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.division = division;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    public String getDivision() {
        return division;
    }
}
