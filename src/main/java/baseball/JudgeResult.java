package baseball;

public class JudgeResult {

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
}
