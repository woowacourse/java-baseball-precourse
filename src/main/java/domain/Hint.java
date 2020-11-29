package domain;

/**
 * @author yhh1056
 * @since 2020/11/28
 */
public class Hint {
    private int strikeCount = 0;
    private int ballCount = 0;

    public void countStrike() {
        strikeCount++;
    }

    public void countBall() {
        ballCount++;
    }
}
