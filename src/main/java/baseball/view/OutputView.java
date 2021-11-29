package baseball.view;

import static baseball.utils.Constant.*;

public class OutputView {

    public static void printInputInstruction() {
        System.out.print(REQUEST_INPUT_MESSAGE);
    }

    public static void printRestartInstrunction() {
        System.out.println(GAME_EXIT_INSTRUCTION);
    }

    public static void printResult(String result) {
        System.out.println(result);
    }
}
