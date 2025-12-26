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

        return ballCount + BALL_SUFFIX + " " + strikeCount + STRIKE_SUFFIX;
    }

    private boolean isNothing() {
        return strikeCount == 0 && ballCount == 0;
    }
}
