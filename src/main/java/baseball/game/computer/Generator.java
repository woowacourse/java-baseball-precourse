package baseball.game.computer;

import baseball.game.collection.Balls;
import baseball.game.util.BallGenerator;

import static baseball.application.GameManager.GAME_SIZE;

public class Generator {
    private final Balls computerBalls;
    private final BallGenerator randomGenerator;

    public Generator(BallGenerator randomGenerator) {
        this.randomGenerator = randomGenerator;
        this.computerBalls = randomGenerator.getBalls(GAME_SIZE);
    }
}
