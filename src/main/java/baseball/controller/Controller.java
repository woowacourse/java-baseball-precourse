package baseball.controller;

import static baseball.utils.Constant.*;

import java.util.List;

import baseball.domain.Computer;
import baseball.domain.Refree;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Controller {

    String status;
    Computer computer;
    Refree refree;
    List<Integer> computerNumbers;
    List<Integer> playerNumbers;

    public Controller() {
        status = ON_GOING;
        computer = new Computer();
        computerNumbers = computer.createRandomNumbers();
        refree = new Refree();
    }

    public void runGame() {
        String result;

        while (isGameStatusOngoing()) {
            OutputView.printInputInstruction();
            playerNumbers = refree.askNumbers(InputView.getInput());

            result = refree.compare(computerNumbers, playerNumbers);
            OutputView.printResult(result);

            if (isThreeStrike(result)) {
                OutputView.printRestartInstrunction();
                status = refree.askRestart(InputView.getInput());
                createNewRandomNumbersByStatus(status);

            }
        }
    }

    private void createNewRandomNumbersByStatus(String status) {
        if (status.equals(ON_GOING)) {
            computerNumbers = computer.createRandomNumbers();
        }
    }

    private boolean isGameStatusOngoing() {
        return !status.equals(STOP);
    }

    private boolean isThreeStrike(String result) {
        return result.equals(RESULT_THREE_STRIKE);
    }
}
