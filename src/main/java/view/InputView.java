package view;

import utils.InputValidator;

import java.util.Scanner;

public class InputView {

    private static final String INCORRECT_NUMBER_ERROR = "올바른 숫자를 입력해주세요.";
    private static final String INCORRECT_MENU_NUM_ERROR = "1번 또는 2번을 입력해주세요.";
    private static final String RESTART = "1";
    private static final String END = "2";
    private static Scanner scanner = new Scanner(System.in);

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public static String inputPlayerNumbers() {
        try {
            OutputView.printInputMessage();
            String playerNumbers = scanner.nextLine();
            int tmpNumbers = Integer.parseInt(playerNumbers);
            InputValidator.validateNumbers(playerNumbers);
            return String.valueOf(playerNumbers);
        }catch (IllegalArgumentException e) {
            e = new IllegalArgumentException(INCORRECT_NUMBER_ERROR);
            return inputPlayerNumbers();
        }
    }

    public static String inputRestartOrEnd() {
        try {
            OutputView.printRestartEnd();
            String selectMenuNum = scanner.nextLine();
            if(selectMenuNum.equals(RESTART) || selectMenuNum.equals(END)) {
                return selectMenuNum;
            }
            throw new IllegalArgumentException(INCORRECT_MENU_NUM_ERROR);
        } catch (IllegalArgumentException e) {
            return inputRestartOrEnd();
        }
    }
}
