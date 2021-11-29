package baseball.constants;

public enum NumbersConstraints {
    MIN_NUMBER(1),
    MAX_NUMBER(9),
    NUMBER_LENGTH(3);
    private final int number;

    NumbersConstraints(int number) {
        this.number = number;
    }

    public int value() {
        return this.number;
    }
}
