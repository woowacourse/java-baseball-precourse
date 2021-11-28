package baseball.Result;

public class StrikeResult extends ResultBase {
    public StrikeResult() {
        super("%d스트라이크");
    }

    @Override
    public final String getMessage(int strikeCount, int ballCount) {
        if (strikeCount > 0 && ballCount == 0) {
            return String.format(message, strikeCount);
        }

        return this.next.getMessage(strikeCount, ballCount);
    }
}
