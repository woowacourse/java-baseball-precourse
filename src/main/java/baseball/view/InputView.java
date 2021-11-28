package baseball.view;

import baseball.constant.SystemMessage;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static String getNumber() {
        System.out.printf(SystemMessage.SET_PLAYER_NUMBER_MESSAGE);
        return Console.readLine();
    }
}
