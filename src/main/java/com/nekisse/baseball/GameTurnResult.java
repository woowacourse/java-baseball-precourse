package com.nekisse.baseball;

public class GameTurnResult {
    private static final int GAME_END_STRIKE_COUNT = 3;
    private int strikeCount;
    private int ballCount;

    public GameTurnResult(int strikeCount, int ballCount) {
        this.strikeCount = strikeCount;
        this.ballCount = ballCount;
    }

    public GameTurnResult() {

    }

    public boolean checkBall() {
        return getBallCount() > 0;
    }

    public boolean checkStrike() {
        return getStrikeCount() > 0;
    }

    public void initialization() {
        strikeCount = 0;
        ballCount = 0;
    }
    public boolean isNothing() {
        return (strikeCount + ballCount) == 0;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    public boolean isEnd() {
        return strikeCount == GAME_END_STRIKE_COUNT;
    }
}
