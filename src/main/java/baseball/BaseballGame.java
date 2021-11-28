package baseball;

import camp.nextstep.edu.missionutils.Console;

import static baseball.InitialSetting.*;

public class BaseballGame {
    private String playerNumber;
    private String computerNumber;

    public void run() {
        do {
            startGame();
        } while (shouldRestartGame());
    }

    private void startGame() {
        generateComputerNumber();
        NumberComparator numberComparator = new NumberComparator();
        numberComparator.setComputerNumber(computerNumber);

        do {
            createPlayerNumber();
            numberComparator.run(playerNumber);
            PrintResult printResult = new PrintResult();
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
        Player player = new Player();
        playerNumber = player.scanNumber();
    }

    private void generateComputerNumber() {
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        computerNumber = randomNumberGenerator.generateNumber();
    }
}
