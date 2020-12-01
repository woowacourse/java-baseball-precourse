package baseball;

import java.util.Scanner;

/**
 * 입력에 관한 가이드를 하는 클래스
 */
public class InputHandler {

    private static final String NUMBER_INPUT_MESSAGE = "숫자를 입력해주세요. : ";
    private static final String RESTART_INPUT_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String INPUT_EXCEPTION_MESSAGE = "잘못된 입력입니다. 3자리의 서로 다른 수를 입력해야 합니다.";
    private static final String RESTART_INPUT_EXCEPTION_MESSAGE = "잘못된 입력입니다. 1(새로시작) 또는 2(종료)를 입력해야 합니다.";
    private static final InputValidator INPUT_VALIDATOR = new InputValidator();
    private final Scanner scanner;

    public InputHandler(Scanner scanner) {
        this.scanner = scanner;
    }

    public String getNumbersInput() {
        System.out.print(NUMBER_INPUT_MESSAGE);
        try {
            return INPUT_VALIDATOR.inputNumber(scanner.nextLine());
        } catch (IllegalArgumentException exception) {
            System.out.println(INPUT_EXCEPTION_MESSAGE);
            return getNumbersInput();
        }
    }

    public boolean getRestartInput() {
        System.out.println(RESTART_INPUT_MESSAGE);
        try {
            return INPUT_VALIDATOR.oneOrTwo(scanner.nextLine());
        } catch (IllegalArgumentException exception) {
            System.out.println(RESTART_INPUT_EXCEPTION_MESSAGE);
            return getRestartInput();
        }
    }


}
