package baseball;

enum Messages {
    COLLECT_ANSWER_MESSAGE("3개의 숫자를 모두 맞히셨습니다! 게임 종료"),
    RESTART_OR_NOT_MESSAGE("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."),
    INPUT_NUMBER_MESSAGE("숫자를 입력해주세요 : "),
    THREE_STRIKE_MESSAGE("3스트라이크");

    private final String messages;

    Messages(final String messages) {
        this.messages = messages;
    }

    String printMessages() {
        return this.messages;
    }
}
