package baseball;

import java.util.Scanner;
import java.util.regex.Pattern;

import baseball.domain.Validator;

public class InputView {

    public static final String ASK_NUMBERS_MESSAGE = "숫자를 입력해주세요 : ";

    public static final String ASK_RETRY_NUMBER = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public static final String INPUT_VALUE_FORMAT = "\n입력한 값은 %s 입니다.";

    private final Validator validator;

    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.validator = new Validator();
        this.scanner = scanner;
    }

    public String askBallNumbers() {
        return ask(ASK_NUMBERS_MESSAGE, Validator.NUMBERS_PATTERN);
    }

    public boolean askRetry() {
        String retryNumber = ask(ASK_RETRY_NUMBER, Validator.RETRY_PATTERN);
        return retryNumber.equals(BaseballGame.GAME_END);
    }

    private String ask(String message, Pattern pattern) {
        System.out.print(message);

        String input = scanner.nextLine();

        boolean isLegalArgument = false;
        while (!isLegalArgument) {
            isLegalArgument = isValid(input, pattern);
        }

        return input;
    }

    private boolean isValid(String input, Pattern pattern) {
        try {
            validator.validateNumbers(pattern, input);
        } catch (IllegalArgumentException e) {
            System.out.printf(e.getMessage() + INPUT_VALUE_FORMAT, input);
            return true;
        }

        return false;
    }
}
