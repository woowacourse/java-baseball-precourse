package baseball;

import camp.nextstep.edu.missionutils.Console;
import static baseball.Message.NEW_GAME_INPUT_ERR_MSG;
import static baseball.Message.NEW_GAME_MSG;

public class BaseballGame {
    private String playerNumber;
    private String computerNumber;

    public void run() {
        do {
            startGame();
        } while (shouldRestartGame());
    }

    public void startGame() {
        setComputer();
        NumberComparator numberComparator = new NumberComparator();
        numberComparator.setComputerNumber(computerNumber);
        do {
            getPlayer();
            numberComparator.run(playerNumber);
            PrintResult printResult = new PrintResult();
            printResult.setNumberComparator(numberComparator);
            printResult.result();
        } while (shouldContinueGame());
    }

    private boolean shouldRestartGame() {
        System.out.println(NEW_GAME_MSG);
        int input = Integer.parseInt(Console.readLine());

        if (input != 1 && input != 2) {
            System.out.println(NEW_GAME_INPUT_ERR_MSG);
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

    private void getPlayer() {
        Player player = new Player();
        playerNumber = player.scanNumber();
    }

    public void setComputer() {
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        computerNumber = randomNumberGenerator.generateNumber();
    }
}
