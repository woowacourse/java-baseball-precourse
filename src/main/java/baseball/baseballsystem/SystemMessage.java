package baseball.baseballsystem;

public enum SystemMessage {
    NUMBER_INPUT_MESSAGE("숫자를 입력해주세요 : "),
    CORRECT_ANSWER_NEXT_MESSAGE("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

    private final String message;

    SystemMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
