package baseball.controller;

import baseball.domain.Computer;
import baseball.domain.Numbers;
import baseball.domain.RandomNumbers;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameController {
    private static final String RESTART_NUMBER = "1";
    private static final String EXIT_NUMBER = "2";

    private List<Integer> randomNumbersList = new ArrayList<>();

    public void run(Scanner scanner) {
        RandomNumbers randomNumbers = new RandomNumbers();
        randomNumbersList = randomNumbers.getRandomNumbers();
        startGame(scanner);
    }

    private void startGame(Scanner scanner) {
        Computer computer = new Computer();
        Numbers numbers = new Numbers();

        String inputNumbersList = InputView.getThreeNumbers(scanner);
        List<Integer> validNumbers = numbers.checkValidNumbers(inputNumbersList);
        computer.calculateResult(validNumbers, randomNumbersList);
        OutputView.printResult(computer.getCountsOfBall(), computer.getCountsOfStrike());
        if (computer.getCountsOfStrike() != 3) {
            startGame(scanner);
        } else {
            OutputView.printRestart();
            restartOrDone(scanner);
        }
    }

    private void restartOrDone(Scanner scanner) {
        String userInputRestart = InputView.getRestartNumber(scanner);
        if (userInputRestart.equals(RESTART_NUMBER)) {
            run(scanner);
        } else if (!userInputRestart.equals(EXIT_NUMBER)) {
            throw new IllegalArgumentException("입력이 올바르지 않습니다.");
        }
    }
}
