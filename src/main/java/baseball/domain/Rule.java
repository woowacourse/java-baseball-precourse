package baseball.domain;

public enum Rule {
    START_INCLUSIVE(1),
    END_INCLUSIVE(9),
    COUNT(3);

    private final int value;

    Rule(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }
}
