package baseball;

import java.util.Scanner;

import baseball.domain.Validator;

public class InputView {

    public static final String ASK_NUMBERS_MESSAGE = "숫자를 입력해주세요 : ";

    private final Validator validator;

    private final Scanner scanner;

    public InputView(Validator validator, Scanner scanner) {
        this.validator = validator;
        this.scanner = scanner;
    }

    public String askNumbers() {
        System.out.print(ASK_NUMBERS_MESSAGE);
        String numbers = scanner.nextLine();
        validator.validateNumbers(Validator.NUMBERS_PATTERN, numbers);
        return numbers;
    }
}
