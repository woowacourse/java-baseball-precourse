package baseball.Result;

public class StrikeAndBallResult extends ResultBase {
    public StrikeAndBallResult() {
        super("%d볼 %d스트라이크" + System.lineSeparator());
    }

    @Override
    public final String getMessage(int strikeCount, int ballCount) {
        if (strikeCount > 0 && ballCount > 0) {
            return String.format(message, ballCount, strikeCount);
        }

        return this.next.getMessage(strikeCount, ballCount);
    }
}
