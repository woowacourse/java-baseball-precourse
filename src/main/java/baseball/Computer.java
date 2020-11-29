package baseball;

public class Computer {
    private Number number;

    public void pickNumber() {
        number = Number.generate();
    }

    public Number getNumber() {
        return number;
    }
}
