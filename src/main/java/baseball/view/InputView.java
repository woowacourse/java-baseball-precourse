package baseball.view;

import java.util.ArrayList;
import java.util.List;

import baseball.exception.BaseballException;
import baseball.resource.GameMessage;
import baseball.resource.GameRule;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static int inputPlayOrStop() {
        OutputView.printMessageWithLine(GameMessage.REQUEST_PLAY_OR_STOP_MESSAGE);
        int number = inputNumber();

        if (number != GameRule.NUMBER_GAME_PLAY && number != GameRule.NUMBER_GAME_STOP) {
            throw new BaseballException(GameMessage.NUMBER_NOT_IN_RANGE_MESSAGE);
        }
        return number;
    }

    private static int inputNumber() {
        try {
            String userInputData = Console.readLine();
            return Integer.parseInt(userInputData);
        } catch (NumberFormatException ex) {
            throw new BaseballException(GameMessage.NOT_NUMBER_MESSAGE);
        }
    }

    public static List<Integer> inputNumbers() {
        try {
            String userInputData = Console.readLine();
            List<Integer> numbers = new ArrayList<>();
            int number;
            for (char item : userInputData.toCharArray()) {
                number = Integer.parseInt(String.valueOf(item));
                numbers.add(number);
            }
            return numbers;
        } catch (NumberFormatException ex) {
            throw new BaseballException(GameMessage.NOT_NUMBER_MESSAGE);
        }
    }
}
