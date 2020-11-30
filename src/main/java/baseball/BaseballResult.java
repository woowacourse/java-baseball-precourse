package baseball;

import static baseball.Constants.GAME_MAX_BASEBALL_PITCH;

public class BaseballResult {

    private final int strikes;
    private final int balls;

    public BaseballResult(BaseballNumbers answerNumbers, BaseballNumbers userGuessNumbers) {
        this.strikes = answerNumbers.calculateStrikes(userGuessNumbers);
        this.balls = answerNumbers.calculateBalls(userGuessNumbers);
    }

    public int getStrikes() {
        return this.strikes;
    }

    public int getBalls() {
        return this.balls;
    }

    public boolean isGameFinished() {
        return this.strikes == GAME_MAX_BASEBALL_PITCH;
    }
}
