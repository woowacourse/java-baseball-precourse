package baseball;

public class Computer {
    Number number;

    public void pickNumber() {
        number = Number.generate();
    }

    public Number getNumber() {
        return number;
    }
}
