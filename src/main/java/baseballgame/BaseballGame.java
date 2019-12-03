package baseballgame;

import baseballgame.view.InputView;

import java.util.List;
import java.util.Objects;

import static baseballgame.view.OutputView.*;

/**
 * @author KSKIM
 * @version 1.0.0
 * @since 2019-11-28
 */
public class BaseballGame {
    private final RandomNumberGenerator randomNumberGenerator;
    private BallCountCalculator ballCountCalculator;

    public BaseballGame(RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = Objects.requireNonNull(randomNumberGenerator);
    }

    public void run() {
        showStartMessage();
        generateRandomNumber();
        guessNumber();
        showCorrectMessage();
    }

    private void generateRandomNumber() {
        List<Integer> randomNumber = randomNumberGenerator.getRandomNumber(Number.TOTAL_NUMBER);
        Number answer = new Number(randomNumber);
        ballCountCalculator = new BallCountCalculator(answer);
    }

    private void guessNumber() {
        BallCount ballCount;
        do {
            Number userNumber = InputView.getNumber();
            ballCount = ballCountCalculator.getBallCount(userNumber);
            showBallCountMessage(ballCount);
        } while (!isStrikeOut(ballCount));
    }

    private boolean isStrikeOut(BallCount ballCount) {
        return ballCount.isStrikeOut();
    }

    public boolean restart() {
        MenuType selectedMenu = InputView.getMenu();
        if (MenuType.EXIT.equals(selectedMenu)) {
            showExitMessage();
            return false;
        }
        return true;
    }
}
