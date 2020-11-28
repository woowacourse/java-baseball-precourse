package baseball;

import java.util.Scanner;

public class InputView {

    public static final String ASK_NUMBERS_MESSAGE = "숫자를 입력해주세요 : ";

    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public String askNumbers() {
        System.out.print(ASK_NUMBERS_MESSAGE);
        return scanner.nextLine();
    }
}
