package domain.game;

import java.util.Map;
import java.util.Set;

public class GameResult {
    private static final String STRIKE_KEY = "스트라이크";
    private static final String BALL_KEY = "볼";
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

    public boolean isNothing() {
        return gameResult.get(STRIKE_KEY) == 0 && gameResult.get(BALL_KEY) == 0;
    }

    public boolean isOnlyStrike() {
        return gameResult.get(STRIKE_KEY) >= 1 && gameResult.get(BALL_KEY) == 0;
    }
}
