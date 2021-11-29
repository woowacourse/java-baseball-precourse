package baseball.domain;

public class GameBallComparator {
    private final int NUMBEROFBALL;
    private MatchStatus status;

    public GameBallComparator(GameBalls mine, GameBalls yours) {
        status = new MatchStatus();
        NUMBEROFBALL = GameBalls.NUMBEROFBALLS;

        compareTwoGameBalls(mine, yours);
    }

    private void compareTwoGameBalls(GameBalls mine, GameBalls yours) {
        for (int i = 0; i < NUMBEROFBALL; i++) {
            for (int j = 0; j < NUMBEROFBALL; j++) {
                calculateMatchCount(mine.getBallByIndex(i), yours.getBallByIndex(j), i, j);
            }
        }
    }

    private void calculateMatchCount(Ball mine, Ball yours, int i, int j) {
        if (mine.equals(yours)) {
            if (i == j) {
                status.countStrikeNumber();
            }
            else {
                status.countBallNumber();
            }
        }
    }

    public String gameResult() {
        return this.status.toString();
    }
}
