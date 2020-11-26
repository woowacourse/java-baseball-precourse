package view;

import utils.InputValidator;

import java.util.Scanner;

public class InputView {
    private static final String INPUT_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String RESTART_OR_END_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    private static Scanner scanner = new Scanner(System.in);

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public static String inputUserNumbers() {
        try {
            System.out.print(INPUT_NUMBER_MESSAGE);
            String userNumbers = scanner.nextLine();
            InputValidator.validateNumbers(userNumbers);
            return userNumbers;
        }catch (IllegalArgumentException e) {
            return inputUserNumbers();
        }
    }
}
