package baseball.domain.game;

import baseball.domain.exception.CannotPlayException;
import baseball.domain.number.BaseballNumbers;

public class BaseballGameMachine {

    private final BaseballNumbers baseballNumbers;

    public BaseballGameMachine(BaseballNumbers baseballNumbers) {
        this.baseballNumbers = baseballNumbers;
    }

    public GameResult calculateGameResult(BaseballNumbers targetBaseballNumbers) {
        int ballCounts = this.baseballNumbers.calculateBallCounts(targetBaseballNumbers);
        int strikeCounts = this.baseballNumbers.calculateStrikeCounts(targetBaseballNumbers);
        return new GameResult(ballCounts, strikeCounts);
    }

    public BaseballGameMachine prepareNextTry(GameState gameState) {
        if (!gameState.isAbleToPlay()) {
            throw new CannotPlayException();
        }
        if (gameState.isRestart()) {
            return new BaseballGameMachine(BaseballNumbers.generateRandomBaseballNumbers());
        }
        return this;
    }
}
