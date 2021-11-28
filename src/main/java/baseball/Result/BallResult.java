package baseball.Result;

public class BallResult extends ResultBase {
    public BallResult() {
        super("%d볼" + System.lineSeparator());
    }

    @Override
    public final String getMessage(int strikeCount, int ballCount) {
        if (strikeCount == 0 && ballCount > 0) {
            return String.format(message, ballCount);
        }

        return this.next.getMessage(strikeCount, ballCount);
    }
}
