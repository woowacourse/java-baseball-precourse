package baseball.game;

import baseball.game.collection.Balls;
import baseball.game.computer.BallSystem;
import baseball.game.computer.OriginalCalculator;
import baseball.game.user.User;
import baseball.game.util.RandomBallGenerator;

import java.util.Scanner;

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
        start();
    }

    private void processWin() {
        System.out.println("win");
        if (!isReplay()) {
            return;
        }
        replay();
    }

    private void replay() {
        BallSystem ballSystem = new BallSystem(new RandomBallGenerator(), new OriginalCalculator());
        Baseball newGame = new Baseball(ballSystem, user);
        newGame.start();
    }

    private boolean isReplay() {
        Scanner sc = new Scanner(System.in);
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int res = checkReplayValue(sc.nextInt());
        return res == 1;
    }

    private int checkReplayValue(int resultValue) {
        if (resultValue != 1 && resultValue != 2) {
            throw new IllegalArgumentException();
        }
        return resultValue;
    }

    private boolean isUserWin(Balls userBalls) {
        return ballSystem.isAllMatch(userBalls);
    }
}
