package baseball.view;

import baseball.domain.players.Computer;
import baseball.domain.players.Users;
import baseball.domain.rule.BaseBallRule;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputView {

    private static final String INPUT_MESSAGES = "숫자를 입력해 주세요 : ";
    private static final int GAME_FINISH_MATCHED_NUMBER = 3;

    OutputView outputView = new OutputView();
    List<Integer> userNumbers;

    public void run() {
        int result;
        Computer computer = Computer.getComputer();

        do {
            List<Integer> userNumbers = setUpUserNumbers();
            BaseBallRule baseBallRule = new BaseBallRule();
            printBaseBallCount(computer, userNumbers, baseBallRule);
            result = baseBallRule.getStrikeCount();
        } while (result != GAME_FINISH_MATCHED_NUMBER);

        isFinished();
    }

    private List<Integer> setUpUserNumbers() {
        String inputNumbers = gameInitMessage();
        return readInputNumber(inputNumbers);
    }

    private void printBaseBallCount(Computer computer, List<Integer> userNumbers, BaseBallRule baseBallRule) {
        outputView.printCompareCountMessage(computer, userNumbers, baseBallRule);
    }

    private void isFinished() {
        outputView.printFinishMessageAndAnswerReplay();
    }

    private String gameInitMessage() {
        System.out.print(INPUT_MESSAGES);
        String inputNumbers = Console.readLine();
        return inputNumbers;
    }


    private List<Integer> readInputNumber(String inputNumbers) {
        Users users = new Users();
        if (users.isValidNumber(inputNumbers)) {
            userNumbers = userNumberSetup(inputNumbers);
        }
        return userNumbers;
    }

    private List<Integer> userNumberSetup(String inputNumbers) {
        userNumbers = new ArrayList<>();
        for (String inputNumber : inputNumbers.split("")) {
            userNumbers.add(Integer.valueOf(inputNumber));
        }
        return userNumbers;
    }
}
