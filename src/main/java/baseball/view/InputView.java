package baseball.view;

import utils.InputValidator;

import java.util.Scanner;

public class InputView {
    private static final String INPUT_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String RESTART_OR_END_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String INCORRECT_MENU_NUM_ERROR = "1 또는 2를 입력해주세요.";
    private static final String RESTART = "1";
    private static final String END = "2";

    private InputView() {
    }

    public static String inputPlayerNumbers(Scanner scanner) {
        try {
            System.out.print(INPUT_NUMBER_MESSAGE);
            return InputValidator.validateNumbers(scanner.nextLine());
        }catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputPlayerNumbers(scanner);
        }
    }

    public static String inputRestartOrEnd(Scanner scanner) {
        try {
            System.out.println(RESTART_OR_END_MESSAGE);
            String selectMenuNum = scanner.nextLine();
            if (selectMenuNum.equals(RESTART) || selectMenuNum.equals(END)) {
                return selectMenuNum;
            }
            throw new IllegalArgumentException(INCORRECT_MENU_NUM_ERROR);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputRestartOrEnd(scanner);
        }
    }
}
