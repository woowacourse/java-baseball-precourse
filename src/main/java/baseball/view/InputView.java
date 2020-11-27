package baseball.view;

import java.util.Scanner;

public class InputView {
    private static final String PLEASE_INPUT_NUMBER = "숫자를 입력해 주세요 : ";
    private static final String PLEASE_INPUT_RESTART_COMMAND = "게임을 시작하려면 1, 종료하려면 2를 입력하세요. ";

    private InputView() {
    }

    public static String getThreeDigitNumber(Scanner scanner) {
        OutputView.printMessage(PLEASE_INPUT_NUMBER);
        return scanner.nextLine();
    }

    public static String getRestartCommand(Scanner scanner) {
        OutputView.printMessageAndNewLine(PLEASE_INPUT_RESTART_COMMAND);
        return scanner.nextLine();
    }
}
