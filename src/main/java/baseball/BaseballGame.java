package baseball;

import camp.nextstep.edu.missionutils.Console;

public class BaseballGame {
    private String playerNumber;
    private String computerNumber;
    private static final String NEW_GAME_MSG = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String NEW_GAME_INPUT_ERR_MSG = "잘못된 입력입니다. 게임 종료";

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
        } while (continueGame());

        startNewGame();
    }

    private void startNewGame() {
        System.out.println(NEW_GAME_MSG);
        int input = Integer.parseInt(Console.readLine());

        if (input != 1 && input != 2) {
            System.out.println(NEW_GAME_INPUT_ERR_MSG);
        }

        if (input == 1) {
            startGame();
        }
    }

    private boolean continueGame() {
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
