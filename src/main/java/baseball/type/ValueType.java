package baseball.type;

public enum ValueType {
    INITIAL_VALUE(0),
    ANSWER_VALUE(3),
    FALSE(0),
    TRUE(1);

    private final int value;

    ValueType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
