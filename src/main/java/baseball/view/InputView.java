package baseball.view;

import baseball.domain.constants.ConstantsMessages;
import baseball.domain.constants.ConstantsNumbers;
import baseball.domain.players.Computer;
import baseball.domain.players.Users;
import baseball.domain.rule.BaseBallRule;
import baseball.domain.rule.ReStartRule;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputView {

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
        } while (result != ConstantsNumbers.GAME_FINISH_MATCHED_NUMBER);
        isReplay();
    }

    private List<Integer> setUpUserNumbers() {
        String inputNumbers = gameInitMessage();
        return readInputNumber(inputNumbers);
    }

    private void printBaseBallCount(Computer computer, List<Integer> userNumbers, BaseBallRule baseBallRule) {
        outputView.printCompareCountMessage(computer, userNumbers, baseBallRule);
    }

    private void isReplay() {
        outputView.printFinishMessageAndAnswerReplay();

        ReStartRule reStartRule = new ReStartRule();
        if(reStartRule.isRestart(Console.readLine())) {
            run();
        }
    }

    private String gameInitMessage() {
        System.out.print(ConstantsMessages.INPUT_MESSAGES);
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
