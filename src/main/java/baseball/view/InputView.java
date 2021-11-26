package baseball.view;

import baseball.constant.SystemMessage;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static String setUserNumber() {
        System.out.printf(SystemMessage.SET_USER_NUMBER_MESSAGE);
        return Console.readLine();
    }
}
