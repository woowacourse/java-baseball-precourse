package baseball.constants;

public enum NumberListConstraints {
    MIN_NUMBER(1),
    MAX_NUMBER(9),
    LIST_LENGTH(3),
    RESTART_FLAG_TRUE(1),
    RESTART_FLAG_FALSE(2);
    private final int number;

    NumberListConstraints(int number) {
        this.number = number;
    }

    public int value() {
        return this.number;
    }
}
