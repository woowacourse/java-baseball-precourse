package baseball.view;

import baseball.constant.SystemMessage;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static String getPlayerNumber() {
        System.out.printf(SystemMessage.SET_PLAYER_NUMBER_MESSAGE);
        return Console.readLine();
    }

    public static char getRetryNumber() {
        System.out.println(SystemMessage.ASK_RETRY_MESSAGE);
        return Console.readLine().charAt(0);
    }
}
