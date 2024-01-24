package baseball.model;

import java.util.HashMap;
import java.util.Map;

public class Result {

    public static final String STRIKE = "strike";
    public static final String BALL = "ball";

    private final Map<String, Integer> counts;

    public Result(Integer strikeCount, Integer ballCount) {
        this.counts = new HashMap<>();
        counts.put(STRIKE, strikeCount);
        counts.put(BALL, ballCount);
    }

    public boolean isGameOver() {
        return counts.get(STRIKE) == 3;
    }

    public boolean hasOnlyStrike() {
        return counts.get(STRIKE) != 0 && counts.get(BALL) == 0;
    }

    public boolean hasOnlyBall() {
        return counts.get(BALL) != 0 && counts.get(STRIKE) == 0;
    }

    public boolean hasNoCounts() {
        return counts.get(BALL) == 0 && counts.get(STRIKE) == 0;
    }

    public int fetchBallCount() {
        return counts.get(BALL);
    }

    public int fetchStrikeCount() {
        return counts.get(STRIKE);
    }
}
