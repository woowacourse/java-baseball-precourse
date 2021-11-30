package baseball.exception.computer;

public class GameResultNegativeCountException extends IllegalArgumentException {

    private static final String GAME_RESULT_NEGATIVE_COUNT_ERROR_MESSAGE = "count는 음수가 입력될 수 없습니다.";

    public GameResultNegativeCountException() {
        super(GAME_RESULT_NEGATIVE_COUNT_ERROR_MESSAGE);
    }
}
