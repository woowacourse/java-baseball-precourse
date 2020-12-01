package baseball.domain.game;

import baseball.domain.exception.InvalidGameResultException;

public class GameResult {
    private static final int MINIMUM_SCORE_COUNT = 0;
    private static final int MAXIMUM_SCORE_COUNT = 3;

    private final int ballCounts;
    private final int strikeCounts;

    public GameResult(int ballCounts, int strikeCounts) {
        validateGameResult(ballCounts, strikeCounts);
        this.ballCounts = ballCounts;
        this.strikeCounts = strikeCounts;
    }

    private void validateGameResult(int ballCounts, int strikeCounts) {
        if (ballCounts < MINIMUM_SCORE_COUNT || ballCounts > MAXIMUM_SCORE_COUNT) {
            throw new InvalidGameResultException(ballCounts, strikeCounts);
        }
        if (strikeCounts < MINIMUM_SCORE_COUNT || strikeCounts > MAXIMUM_SCORE_COUNT) {
            throw new InvalidGameResultException(ballCounts, strikeCounts);
        }
        if (ballCounts + strikeCounts > MAXIMUM_SCORE_COUNT) {
            throw new InvalidGameResultException(ballCounts, strikeCounts);
        }
    }

    public boolean isEndOfGame() {
        return this.strikeCounts == MAXIMUM_SCORE_COUNT;
    }

    public boolean isNothing() {
        return this.ballCounts == MINIMUM_SCORE_COUNT && this.strikeCounts == MINIMUM_SCORE_COUNT;
    }

    public boolean isOnlyStrike() {
        return this.ballCounts == MINIMUM_SCORE_COUNT && this.strikeCounts != MINIMUM_SCORE_COUNT;
    }

    public boolean isOnlyBall() {
        return this.ballCounts != MINIMUM_SCORE_COUNT && this.strikeCounts == MINIMUM_SCORE_COUNT;
    }

    public int getBallCounts() {
        return this.ballCounts;
    }

    public int getStrikeCounts() {
        return this.strikeCounts;
    }
}
