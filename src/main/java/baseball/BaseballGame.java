package baseball;

import utils.ComparisonBalls;
import utils.OutputView;

import java.util.Scanner;

import static utils.Constant.*;

public class BaseballGame {

    private Player player;
    private Computer computer;
    private int strike;
    private int ball;

    public BaseballGame(Scanner scanner) {
        computer = new Computer();
        computer.setBalls();
        player = new Player(scanner);
        strike = INITIAL_GAME_STATUS_COUNT;
        ball = INITIAL_GAME_STATUS_COUNT;
    }

    public boolean isGameEnd() {
        if (strike == BALLS_LENGTH) {
            OutputView.printGameEnd();
            return true;
        }
        return false;
    }

    public void inputPlayerBalls() {
        player.inputBalls();
    }

    public void getHint() {
        compareBalls();
        OutputView.printHint(strike, ball);
    }

    public void compareBalls() {
        strike = ComparisonBalls.getStrikeCount(computer.getBalls(), player.getBalls());
        ball = ComparisonBalls.getBallCount(computer.getBalls(), player.getBalls());
    }

}
