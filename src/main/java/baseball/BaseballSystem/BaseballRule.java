package baseball.BaseballSystem;

public enum BaseballRule {
    CONTINUE_GAME("1"),
    END_GAME("2"),
    INPUT_VALIDATION_LENGTH("3");
    private final String value;

    BaseballRule(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
