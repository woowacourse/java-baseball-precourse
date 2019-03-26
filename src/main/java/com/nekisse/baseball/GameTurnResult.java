package com.nekisse.baseball;

public class GameTurnResult {
    private static final int GAME_END_STRIKE_COUNT = 3;
    private int strikeCount;
    private int ballCount;

    public GameTurnResult(int strikeCount, int ballCount) {
        this.strikeCount = strikeCount;
        this.ballCount = ballCount;
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
