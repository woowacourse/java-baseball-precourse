package baseball;

import java.util.Scanner;

public class BaseballGameInput {
    final String BASEBALLS_INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    final String RESTART_OR_EXIT_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    Scanner scanner;

    public BaseballGameInput(Scanner scanner) {
        this.scanner = scanner;
    }

    public String baseballNumbersInput() {
        System.out.println(BASEBALLS_INPUT_MESSAGE);
        return scanner.nextLine();
    }

    public String restartOrExitInput() {
        System.out.println(RESTART_OR_EXIT_MESSAGE);
        return scanner.nextLine();
    }
}
