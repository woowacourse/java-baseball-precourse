package baseball.game.computer;

import baseball.game.collection.Balls;
import baseball.game.util.BallGenerator;

import static baseball.application.GameManager.GAME_SIZE;

public class BallSystem {
    private final Balls computerBalls;
    private final Calculator calculator;

    public BallSystem(BallGenerator randomGenerator, Calculator calculator) {
        this.computerBalls = randomGenerator.getBalls(GAME_SIZE);
        this.calculator = calculator;
    }

    public boolean isAllMatch(Balls userBalls) {
        return calculator.isWin(computerBalls, userBalls);
    }
}
