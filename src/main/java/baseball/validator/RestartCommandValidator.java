package baseball.validator;

public class RestartCommandValidator {
    private static final String RESTART = "1";
    private static final String TERMINATE = "2";
    private static final String PLEASE_INPUT_ONE_OR_TWO = "입력값은 1혹은 2 둘 중 하나이어야 합니다. ";

    private RestartCommandValidator() {
    }

    public static void validateRestartCommand(String restartCommand) {
        if (!restartCommand.equals(RESTART) && !restartCommand.equals(TERMINATE)) {
            throw new IllegalArgumentException(PLEASE_INPUT_ONE_OR_TWO);
        }
    }
}
