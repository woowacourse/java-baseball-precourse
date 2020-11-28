package baseball;

import baseball.constant.Constants;
import baseball.model.Computer;
import baseball.model.User;
import baseball.service.*;
import baseball.view.OutputView;
import utils.StringToListIntegerutils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BaseballGameController {
    private Computer computer;
    private User user;

    BaseballGameController(Computer computer, User user) {
        this.computer = computer;
        this.user = user;
    }

    public void updateAnswer() {
        computer.setAnswer(AnswerGenerator.generateAnswer());
    }

    public List<Integer> fetchAnswer() {
        return computer.getAnswer();
    }

    public void updateUserNumber(Scanner scanner) {
        String number = InputMachine.inputUserNumber(scanner);

        if (InputValidator.validateUserNumber(number)) {
            user.setUserNumber(StringToListIntegerutils.convertToList(number));
            return;
        }

        OutputView.showError(OutputView.ERROR_MESSAGE);
    }

    public List<Integer> fetchUserNumber() {
        return user.getUserNumber();
    }

    public void resetUserNumber() {
        user.setUserNumber(new ArrayList<Integer>());
    }

    public void comparingProcess() {
        BallCounter.count(fetchAnswer(), fetchUserNumber());
    }

    public void updateRecord() {
        computer.getRecord()
                .setBall(BallCounter
                        .getBallCount());
        computer.getRecord()
                .setStrike(BallCounter
                        .getStrikeCount());
    }

    public void printResult() {
        OutputMachine.print(computer.getRecord());
    }

    public void updateRetryNumber(Scanner scanner) {
        String number = InputMachine.inputRetryNumber(scanner);

        if (InputValidator.validateRetryNumber(number)) {
            user.setRetryNumber(Integer.parseInt(number));
            return;
        }
        user.setRetryNumber(Constants.INVALID_RETRY_NUMBER);
        OutputView.showError(OutputView.ERROR_MESSAGE);
    }

    public int fetchRetryNumber() {
        return user.getRetryNumber();
    }
}
