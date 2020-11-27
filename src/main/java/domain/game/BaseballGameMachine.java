package domain.game;

import domain.number.BaseballNumbers;

import java.util.HashMap;
import java.util.Map;

public class BaseballGameMachine {
    private static final String STRIKE_KEY = "스트라이크";
    private static final String BALL_KEY = "볼";

    private final BaseballNumbers baseballNumbers;

    public BaseballGameMachine(BaseballNumbers baseballNumbers) {
        this.baseballNumbers = baseballNumbers;
    }

    public GameResult play(BaseballNumbers targetBaseballNumbers) {
        Map<String, Integer> gameResult = new HashMap<>();
        int ballCounts = this.baseballNumbers.calculateBallCounts(targetBaseballNumbers);
        int strikeCounts = this.baseballNumbers.calculateStrikeCounts(targetBaseballNumbers);
        gameResult.put(BALL_KEY, ballCounts);
        gameResult.put(STRIKE_KEY, strikeCounts);
        return new GameResult(gameResult);
    }
}
