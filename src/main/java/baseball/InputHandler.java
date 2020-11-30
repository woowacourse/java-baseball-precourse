package baseball;

import java.util.Scanner;

/**
 * 입력에 관한 가이드를 하는 클래스
 */
public class InputHandler {
    private static final String NUMBER_INPUT_MESSAGE = "숫자를 입력해주세요. : ";
    private static final String RESTART_INPUT_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final CheckInputNumber checkInputNumber = new CheckInputNumber();
    private final Scanner scanner;

    InputHandler(Scanner scanner) {
        this.scanner = scanner;
    }

    public String inputValue() {
        System.out.print(NUMBER_INPUT_MESSAGE);
        return checkInputNumber.inputNumber(scanner.nextLine());
    }

    public boolean restartValue() {
        System.out.println(RESTART_INPUT_MESSAGE);
        return checkInputNumber.oneOrTwo(scanner.nextLine());
    }


}
