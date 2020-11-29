package baseball;

import baseball.domain.Computer;
import baseball.domain.NumbersComparator;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.Scanner;

public class BaseballGame {
    private static final String RESTART = "1";

    private final Computer computer;
    private final Scanner scanner;
    private final NumbersComparator numbersComparator;

    public BaseballGame(Scanner scanner) {
        computer = new Computer();
        numbersComparator = new NumbersComparator();
        this.scanner = scanner;
    }

    public void play() {
        String computerNumbers = computer.createRandomComputerNumbers();
        do {
            String playerNumbers = InputView.inputPlayerNumbers(scanner);
            numbersComparator.compareNumbers(computerNumbers, playerNumbers);
        } while (!numbersComparator.isStrikeThree());
        OutputView.printCorrectAnswer();
    }

    public boolean isRestart() {
        if (InputView.inputRestartOrEnd(scanner).equals(RESTART)) {
            return true;
        }
        return false;
    }
}


