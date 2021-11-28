package baseball.Result;

public class BallResult extends ResultBase{
    public BallResult() {
        super(
                ResultType.BALL,
                "%d볼" + System.lineSeparator()
        );
    }

    @Override
    public final String getMessage(int strikeCount, int ballCount, ResultType resultType) {
        if (this.resultType.equals(resultType)) {
            return String.format(message, ballCount);
        }

        return this.next.getMessage(strikeCount, ballCount, resultType);
    }
}
