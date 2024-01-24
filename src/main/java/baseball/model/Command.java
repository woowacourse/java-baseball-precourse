package baseball.model;

public class Command {

    public static final String VALIDATION_ERROR_MESSAGE = "1,2 중 입력해주세요.";
    public static final int REPLAY_COMMAND = 1;
    public static final int STOP_COMMAND = 2;

    private final int value;

    public Command(int value) {
        validate(value);
        this.value = value;
    }

    private void validate(int value) {
        if (value != REPLAY_COMMAND && value != STOP_COMMAND) {
            throw new IllegalArgumentException(VALIDATION_ERROR_MESSAGE);
        }
    }

    public boolean isReplay() {
        return value == REPLAY_COMMAND;
    }
}
