package baseball;

public enum Constant {
    MIN_NUMBER(1), MAX_NUMBER(9), NUMBER_COUNT(3);

    private int value;

    Constant(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
