package streams;

public class NameCounterMod {

    private int threePartName = 0;
    private int twoPartName = 0;

    public NameCounterMod() {
    }

    public int getThreePartName() {
        return threePartName;
    }

    public int getTwoPartName() {
        return twoPartName;
    }

    public void add(Employee employee) {
        if (employee.getName().split(" ").length == 2) {
            ++twoPartName;
        } else {
            ++threePartName;
        }
    }

    public void add(NameCounterMod other) {
        this.threePartName += other.getThreePartName();
        this.twoPartName += other.getTwoPartName();
    }
}
