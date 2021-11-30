package baseball;

public class GameResult {
    private static final String STRIKE_TO_PRINT = "스트라이크";
    private static final String BALL_TO_PRINT = "볼";
    private static final String NOTHING = "낫싱";

    private final int strike;
    private final int ball;

    public GameResult(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public boolean isThreeStrike() {
        return strike == 3;
    }

    public String toPrint() {
        StringBuilder resultStringBuilder = makeResultToStringBuilder();
        if (resultStringBuilder.length() == 0) {
            return NOTHING;
        }
        return resultStringBuilder.toString();
    }

    private StringBuilder makeResultToStringBuilder() {
        StringBuilder stringBuilder = new StringBuilder();
        if (ball > 0) {
            stringBuilder.append(ball);
            stringBuilder.append(BALL_TO_PRINT);
        }
        if (strike > 0) {
            if (stringBuilder.length() > 0) {
                stringBuilder.append(" ");
            }
            stringBuilder.append(strike);
            stringBuilder.append(STRIKE_TO_PRINT);
        }
        return stringBuilder;
    }
}
