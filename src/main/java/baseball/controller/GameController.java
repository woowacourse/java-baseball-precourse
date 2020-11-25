package baseball.controller;

import baseball.domain.Computer;
import baseball.domain.Numbers;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.List;
import java.util.Scanner;

public class GameController {
    public void run(Scanner scanner){
        startGame(scanner);
    }

    private void startGame(Scanner scanner) {
        Computer computer = new Computer();
        Numbers numbers = new Numbers();

        String threeNumbers = InputView.getThreeNumbers(scanner);
        List<Integer> validNumbers = numbers.isValidNumbers(threeNumbers);
        computer.calculateResult(validNumbers);
        OutputView.printResult(computer.getCountsOfBall(), computer.getCountsOfStrike());
    }
}
