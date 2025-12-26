package baseball;

public enum OutputMessage {
    NUMBER_INPUT_MESSAGE("숫자를 입력해 주세요 : "),
    ENDING_MESSAGE("3개의 숫자를 모두 맞히셨습니다! 게임 종료"),
    RESTART_MESSAGE("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."),
    NOTHING_MESSAGE("낫싱");


    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
