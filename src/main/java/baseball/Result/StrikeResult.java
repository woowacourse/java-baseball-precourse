package baseball.Result;

public class StrikeResult extends ResultBase {
    public StrikeResult() {
        super(
                ResultType.STRIKE,
                "%d스트라이크" + System.lineSeparator()
        );
    }

    @Override
    public final String getMessage(int strikeCount, int ballCount, ResultType resultType) {
        if (this.resultType.equals(resultType)) {
            return String.format(message, strikeCount);
        }

        return this.next.getMessage(strikeCount, ballCount, resultType);
    }
}
