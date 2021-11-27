package baseball;

public enum RestartInput {
    RESTART("1"),
    FINISH("2");

    private final String number;

    RestartInput(String number) {
        this.number = number;
    }

    public static RestartInput byNumber(String number) {
        for (RestartInput input : RestartInput.values()) {
            if (input.number.equals(number)) {
                return input;
            }
        }
        throw new IllegalArgumentException();
    }
}
