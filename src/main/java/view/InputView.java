package view;

import java.util.Scanner;

public class InputView {
    private static final String PLEASE_INPUT_NUMBER = "숫자를 입력해 주세요 : ";

    private InputView() {
    }

    public static String getThreeDigitNumber(Scanner scanner) {
        OutputView.printMessage(PLEASE_INPUT_NUMBER);
        return scanner.nextLine();
    }
}
