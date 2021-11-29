package baseball.constants;

public enum GameMessages {
    USER_EXPECTATION_PROMPT("숫자를 입력해주세요 : "),
    RESTART_GAME_PROMPT("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n"),
    GAME_OVER_MESSAGE("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
    ;

    private final String message;

    GameMessages(String message) {
        this.message = message;
    }

    public String message() {
        return this.message;
    }
}
