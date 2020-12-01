package baseball.controller;

import baseball.domain.Computer;
import baseball.domain.GameStatus;

import java.util.List;
import java.util.Scanner;

import static baseball.util.Validator.REQUIRE_NUMBER_COUNT;

public class GameController {

    private static Computer computer;
    private static InputController inputController;
    private static ConsoleView consoleView = new ConsoleView();

    private static int GAME_SUCCESS_COUNT = 3;

    public GameController(Scanner scanner) {
        this.inputController = new InputController(scanner);
    }

    public void run() {

        initComputer();

        initPlayerInput();

        isRestart();

    }

    private void initComputer() {
        this.computer = Computer.create();
    }

    private static void initPlayerInput() {

        List<Integer> numbers = inputController.input();

        GameStatus status = checkNumbers(numbers);

        if (status == GameStatus.RETRY) {
            initPlayerInput();
        }

    }

    private static GameStatus checkNumbers(List<Integer> numbers) {

        checkBall(numbers);
        int strikeCount = checkStrike(numbers);

        consoleView.printResult();
        if (strikeCount < GAME_SUCCESS_COUNT) {
            return GameStatus.RETRY;
        }

        return GameStatus.SUCCESS;
    }

    private static int checkBall(List<Integer> numbers) {
        int ballCount = getSameNumberCount(numbers) - getStrikeCount(numbers);
        consoleView.setBallCount(ballCount);
        return ballCount;
    }

    private static int getSameNumberCount(List<Integer> numbers) {
        int count = 0;
        for (Integer number : numbers) {
            if (computer.hasNumber(number)) {
                count++;
            }
        }
        return count;
    }

    private static int checkStrike(List<Integer> input) {
        int strikeCount = getStrikeCount(input);
        consoleView.setStrikeCount(strikeCount);
        return strikeCount;
    }

    private static int getStrikeCount(List<Integer> numbers) {

        int count = 0;
        for (int index = 0; index < REQUIRE_NUMBER_COUNT; index++) {
            int targetNumber = numbers.get(index);
            if (computer.hasNumberOfIndex(targetNumber, index)) {
                count++;
            }
        }
        return count;
    }

    private void isRestart() {
        GameStatus gameStatus = inputController.inputRestart();
        if (gameStatus == GameStatus.RESTART) {
            run();
        }
    }

}
