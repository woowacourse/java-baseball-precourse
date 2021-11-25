package baseball.domain;

public class BaseballState {
    private static final String BALL = "%d볼";
    private static final String STRIKE = "%d스트라이크";
    private static final String BALL_AND_STRIKE = "%d볼 %d스트라이크";
    private static final String NOTTING = "낫싱";
    private static final int ZERO_COUNT = 0;
    private static final int SUCCESS_STRIKE_COUNT = 3;

    private final int ballCount;
    private final int strikeCount;

    public BaseballState(int ballCount, int strikeCount) {
        this.ballCount = ballCount;
        this.strikeCount = strikeCount;
    }

    public boolean isSuccess() {
        if (strikeCount == SUCCESS_STRIKE_COUNT) {
            return true;
        }
        return false;
    }

    public String getMessage() {
        if (ballCount == ZERO_COUNT && strikeCount == ZERO_COUNT) {
            return NOTTING;
        }

        if (ballCount == ZERO_COUNT) {
            return String.format(STRIKE, strikeCount);
        }

        if (strikeCount == ZERO_COUNT) {
            return String.format(BALL, ballCount);
        }

        return String.format(BALL_AND_STRIKE, ballCount, strikeCount);
    }
}