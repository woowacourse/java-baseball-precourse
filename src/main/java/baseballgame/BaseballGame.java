package baseballgame;

import java.util.List;
import java.util.Objects;

/**
 * @author KSKIM
 * @version 1.0.0
 * @since 2019-11-28
 */
public class BaseballGame {
    private static final String MESSAGE_START_GAME = "# 새로운 게임을 시작합니다.";
    private static final String MESSAGE_EXIT_GAME = "# 게임을 종료합니다.";
    private static final String MESSAGE_CORRECT_NUMBER = "# 정답입니다.";

    private final RandomNumberGenerator randomNumberGenerator;
    private BallCountCalculator ballCountCalculator;

    public BaseballGame(RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = Objects.requireNonNull(randomNumberGenerator);
    }

    public void run() {
        System.out.println(MESSAGE_START_GAME);
        generateRandomNumber();
        guessNumber();
    }

    private void generateRandomNumber() {
        List<Integer> randomNumber = randomNumberGenerator.getRandomNumber(Number.TOTAL_NUMBER);
        Number answer = Number.valueOf(randomNumber);
        ballCountCalculator = new BallCountCalculator(answer);
    }

    private void guessNumber() {
        while(true) {
            Number userNumber = InputView.getNumber();
            BallCount ballCount = ballCountCalculator.getBallCount(userNumber);
            System.out.println(ballCount);

            if (ballCount.isStrikeOut()) {
                System.out.println(MESSAGE_CORRECT_NUMBER);
                break;
            }
        }
    }

    public boolean restart() {
        MenuType selectedMenu = InputView.getMenu();
        if (MenuType.EXIT.equals(selectedMenu)) {
            System.out.println(MESSAGE_EXIT_GAME);
            return false;
        }
        return true;
    }
}
