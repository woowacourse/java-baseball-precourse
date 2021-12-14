package baseball.view;

import java.util.Map;

import static baseball.model.Constants.*;

public class OutputView {
    public static void printInputMsg() {
        System.out.print(INPUT_NUMBER_MSG);
    }

    public static void printResultMsg(String gameResultMsg) {
        System.out.println(gameResultMsg);
    }

    public static void printEndMsg() {
        System.out.println(GAME_END_MSG);
    }

    public static void printAskRestartMsg() {
        System.out.println(GAME_RESTART_OR_STOP_MSG);
    }

    public static void printErrorMsg(Exception e) {

    }
}
