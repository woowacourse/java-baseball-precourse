package baseball.controller;

import baseball.domain.Computer;
import baseball.domain.Numbers;
import baseball.domain.RandomNumbers;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.List;
import java.util.Scanner;

public class GameController {
    RandomNumbers randomNumbers = new RandomNumbers();
    private final List<Integer> randomNumberList = randomNumbers.getRandomNumbers();

    public void run(Scanner scanner){
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
//        if(computer.getCountsOfStrike()==3){
//            OutputView.printRestart();
//            if(InputView.getRestartNumber(scanner).equals(RESTART_NUMBER)){
//                startGame(scanner);
//            }
//            else if(!InputView.getRestartNumber(scanner).equals(EXIT_NUMBER)) {
//                throw new IllegalArgumentException("입력이 올바르지 않습니다.");
//            }
//        }
    }
}
