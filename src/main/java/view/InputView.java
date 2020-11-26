package view;

import utils.InputValidator;

import java.util.Scanner;

public class InputView {


    private static Scanner scanner = new Scanner(System.in);

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public static String inputPlayerNumbers() {
        try {
            OutputView.printInputMessage();
            String userNumbers = scanner.nextLine();
            InputValidator.validateNumbers(userNumbers);
            return userNumbers;
        }catch (IllegalArgumentException e) {
            return inputPlayerNumbers();
        }
    }
}
