package baseball.view;

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
}
