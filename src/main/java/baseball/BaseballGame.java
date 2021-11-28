package baseball;

import camp.nextstep.edu.missionutils.Console;

import static baseball.InitialSetting.*;

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
        NumberComparator numberComparator = new NumberComparator();
        PrintResult printResult = new PrintResult();

        do {
            createPlayerNumber();
            NumberComparator.compare(computerNumber, playerNumber);
            printResult.setNumberComparator(numberComparator);
            printResult.result();
        } while (shouldContinueGame());
    }

    private boolean shouldRestartGame() {
        System.out.println(NEW_GAME_MSG);
        int input = Integer.parseInt(Console.readLine());

        if (input != RESTART_GAME && input != END_GAME) {
            throw new IllegalArgumentException(NEW_GAME_INPUT_ERR_MSG);
        }

        if (input == 1) {
            return true;
        }

        return false;
    }

    private boolean shouldContinueGame() {
        if (computerNumber.equals(playerNumber)) {
            return false;
        }

        return true;
    }

    private void createPlayerNumber() {
        playerNumber = Player.scanNumber();
    }
}
