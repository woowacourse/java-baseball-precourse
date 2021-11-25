package baseball.view;

import java.util.ArrayList;
import java.util.List;

import baseball.exception.BaseballException;
import baseball.resource.GameMessage;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static int inputNumber() {
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
