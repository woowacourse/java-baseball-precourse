package baseball;

import baseball.util.NumberComparator;
import baseball.util.RandomNumberGenerator;
import camp.nextstep.edu.missionutils.Console;

import static baseball.config.Constant.*;
import static baseball.config.Message.*;

public class BaseballGame {
    private GameNumber computerNumber;
    private GameNumber playerNumber;

    public void run() {
        do {
            initGame();
            playGame();
        } while (shouldRestartGame());
    }

    private void initGame() {
        computerNumber = RandomNumberGenerator.generateNumber();
    }

    private void playGame() {
        do {
            createPlayerNumber();
            PrintResult printResult = NumberComparator.compare(computerNumber, playerNumber);
            NumberComparator.clearStrikeAndBall();
            System.out.println(printResult.toString());
        } while (shouldContinueGame());
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

    private void createPlayerNumber() {
        playerNumber = Player.scanNumber();
    }
}
