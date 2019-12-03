package baseball.game;

import baseball.game.collection.Balls;
import baseball.game.computer.BallSystem;
import baseball.game.user.User;

import static baseball.application.GameManager.GAME_SIZE;

public class Baseball {

    private final BallSystem ballSystem;
    private final User user;

    public Baseball(BallSystem ballSystem, User user) {
        this.ballSystem = ballSystem;
        this.user = user;
    }

    public void start() {
        Balls userBalls = user.getGameBalls(GAME_SIZE);
        if (isUserWin(userBalls)) {
            processWin();
            return;
        }
        processLose();
    }

    private void processLose() {
        System.out.println("lose");
    }

    private void processWin() {
        System.out.println("win");
    }

    private boolean isUserWin(Balls userBalls) {
        return false;
    }
}
