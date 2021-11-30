package baseball;

import static baseball.StringUtil.*;

public class GameResult {
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
