package baseball.Result;

public class StrikeAndBallResult extends ResultBase {
    public StrikeAndBallResult() {
        super(
                ResultType.STRIKE_AND_BALL,
                "%d볼 %d스트라이크" + System.lineSeparator()
        );
    }

    @Override
    public final String getMessage(int strikeCount, int ballCount, ResultType resultType) {
        if (this.resultType.equals(resultType)) {
            return String.format(message, ballCount, strikeCount);
        }

        return this.next.getMessage(strikeCount, ballCount, resultType);
    }
}
