package domain.game;

import java.util.Map;
import java.util.Set;

public class GameResult {
    private static final String STRIKE_KEY = "strike";
    private static final String BALL_KEY = "ball";
    private static final int VALID_KEY_COUNTS = 2;

    private final Map<String, Integer> gameResult;

    public GameResult(Map<String, Integer> gameResult) {
        validateGameResult(gameResult);
        this.gameResult = gameResult;
    }

    private void validateGameResult(Map<String, Integer> gameResult) {
        Set<String> gameResultKeys = gameResult.keySet();
        if (gameResultKeys.size() != VALID_KEY_COUNTS) {
            throw new IllegalArgumentException();
        }
        if (!gameResultKeys.contains(STRIKE_KEY) || !gameResultKeys.contains(BALL_KEY)) {
            throw new IllegalArgumentException();
        }
    }
}
