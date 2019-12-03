package baseball.game.user;

import baseball.game.collection.Balls;
import baseball.game.util.BallGenerator;

public class User {
    private final BallGenerator ballGenerator;

    public User(BallGenerator ballGenerator) {
        this.ballGenerator = ballGenerator;
    }

    public Balls getGameBalls(int gameSize) {
        return ballGenerator.getBalls(gameSize);
    }
}
