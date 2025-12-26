package baseball;

public class JudgeResult {

    public static final String BALL_SUFFIX = "볼";
    public static final String STRIKE_SUFFIX = "스트라이크";

    private int strikeCount;
    private int ballCount;

    private JudgeResult(int strikeCount, int ballCount) {
        this.strikeCount = strikeCount;
        this.ballCount = ballCount;
    }

    public static JudgeResult of(int strikeCount, int ballCount) {
        return new JudgeResult(strikeCount, ballCount);
    }

    public boolean isCorrect() {
        return strikeCount == 3;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    public String getResultMessage() {
        if(isNothing()) {
            return OutputMessage.NOTHING_MESSAGE.getMessage();
        }

        String message = "";
        if(ballCount > 0) {
            message += ballCount + BALL_SUFFIX + " ";
        }

        if(strikeCount > 0) {
            message += strikeCount + STRIKE_SUFFIX;
        }

        return message;
    }

    private boolean isNothing() {
        return strikeCount == 0 && ballCount == 0;
    }
}
