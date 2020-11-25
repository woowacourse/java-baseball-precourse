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

    private List<Integer> randomNumberList = new ArrayList<>();

    public void run(Scanner scanner){
        RandomNumbers randomNumbers = new RandomNumbers();
        randomNumberList = randomNumbers.getRandomNumbers();
        startGame(scanner);
    }

    private void startGame(Scanner scanner) {
        Computer computer = new Computer();
        Numbers numbers = new Numbers();

        String threeNumbers = InputView.getThreeNumbers(scanner);
        List<Integer> validNumbers = numbers.isValidNumbers(threeNumbers);
        computer.calculateResult(validNumbers, randomNumberList);
        OutputView.printResult(computer.getCountsOfBall(), computer.getCountsOfStrike());
        if(computer.getCountsOfStrike()!=3){
            startGame(scanner);
        }
        else {
            OutputView.printRestart();
            if(InputView.getRestartNumber(scanner).equals(RESTART_NUMBER)){
                run(scanner);
            }
            else if(!InputView.getRestartNumber(scanner).equals(EXIT_NUMBER)) {
                throw new IllegalArgumentException("입력이 올바르지 않습니다.");
            }
        }
    }
}
