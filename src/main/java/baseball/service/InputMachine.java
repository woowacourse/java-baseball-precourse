package baseball.service;

import baseball.view.InputView;

import java.util.Scanner;

public class InputMachine {
    private InputMachine() {
    }

    public static String inputUserNumber(Scanner scanner) {
        InputView.setUserNumber();
        return scanner.nextLine();
    }

    public static String inputRetryNumber(Scanner scanner) {
        InputView.setRetryNumber();
        return scanner.nextLine();
    }
}
