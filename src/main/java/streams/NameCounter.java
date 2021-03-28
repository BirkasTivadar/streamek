package streams;

public class NameCounter {

    private int threePartName = 0;
    private int twoPartName = 0;

    public NameCounter() {
    }

    public NameCounter(int threePartName, int twoPartName) {
        this.threePartName = threePartName;
        this.twoPartName = twoPartName;
    }

    public int getThreePartName() {
        return threePartName;
    }

    public int getTwoPartName() {
        return twoPartName;
    }

    public NameCounter add(Employee employee) {
        if (employee.getName().split(" ").length == 2) {
            return new NameCounter(threePartName, ++twoPartName);
        } else {
            return new NameCounter(++threePartName, twoPartName);
        }
    }

    public NameCounter add(NameCounter other) {
        return new NameCounter(this.threePartName + other.threePartName, this.twoPartName + other.twoPartName);
    }
}

