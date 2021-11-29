package baseball.BaseballSystem.validation;

public enum InputValidationRule {
    CONTINUE_GAME("1"),
    END_GAME("2"),
    INPUT_VALIDATION_LENGTH("3");

    private final String value;

    InputValidationRule(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
