
/*
 * MatchResult.java
 * @author crystal_rim
 * @version 1.0.0
 * @date 2019-12-02
 */
package game.domain;

public class MatchResult {
    private final int strikeCount;
    private final int ballCount;

    /**
     * Create the result of matching.
     * @param strikeCount
     * @param ballCount
     */
    public MatchResult(int strikeCount, int ballCount) {
        this.strikeCount = strikeCount;
        this.ballCount = ballCount;
    }

    public boolean isExistStrike() {
        return strikeCount > 0;
    }

    public boolean isExistBall() {
        return ballCount > 0;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    public boolean isStrokeAll() {
        return strikeCount == Numbers.SIZE;
    }

}