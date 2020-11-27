package baseball.domain;

import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.Scanner;

public class BaseballGame {
    private static final String RESTART = "1";
    private Computer computer;
    private String computerNumbers;
    private String playerNumbers;
    private Scanner scanner;
    private NumbersComparator numbersComparator;

    public BaseballGame(Scanner scanner) {
        computer = new Computer();
        numbersComparator = new NumbersComparator();
        this.scanner = scanner;
    }

    public void play() {
        computerNumbers = computer.createRandomComputerNumbers();
        do {
            playerNumbers = InputView.inputPlayerNumbers(scanner);
            numbersComparator.compareNumbers(computerNumbers, playerNumbers);
        } while (!numbersComparator.isStrikeThree());
        OutputView.printCorrectAnswer();
    }

    public boolean isRestart() {
        if(InputView.inputRestartOrEnd(scanner).equals(RESTART)) {
            return true;
        }
        return false;
    }
}


