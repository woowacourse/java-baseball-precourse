package baseball;

import baseball.util.NumberComparator;
import baseball.util.RandomNumberGenerator;
import camp.nextstep.edu.missionutils.Console;

import static baseball.config.Constant.*;
import static baseball.config.Message.*;

public class BaseballGame {
    private GameNumber computerNumber;
    private GameNumber playerNumber;
    private Result result;

    public void run() {
        do {
            initGame();
            playGame();
        } while (shouldRestartGame());
    }

    private void playGame() {
        do {
            createPlayerNumber();
            processGame();
            printResult();
        } while (shouldContinueGame());
    }

    private void initGame() {
        computerNumber = RandomNumberGenerator.generateNumber();
    }

    private void createPlayerNumber() {
        playerNumber = Player.scanNumber();
    }

    private void processGame() {
        result = NumberComparator.compare(computerNumber, playerNumber);
        NumberComparator.clearStrikeAndBall();
    }

    private void printResult() {
        System.out.println(result.toString());
    }

    private boolean shouldRestartGame() {
        System.out.println(NEW_GAME_MSG);
        int input = Integer.parseInt(Console.readLine());

        if (input != RESTART_GAME && input != END_GAME) {
            throw new IllegalArgumentException(NEW_GAME_INPUT_ERR_MSG);
        }

        return input == RESTART_GAME;
    }

    private boolean shouldContinueGame() {
        return !computerNumber.getGameNumber().equals(playerNumber.getGameNumber());
    }
}
