package baseball.view;

import java.util.Scanner;
import java.util.regex.Pattern;

import baseball.BaseballGame;
import baseball.domain.Validator;

public class InputView {

    private static final String ASK_NUMBERS_MESSAGE = "숫자를 입력해주세요 : ";

    private static final String ASK_RETRY_NUMBER = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    private static final String INPUT_VALUE_FORMAT = "\n입력한 값은 %s 입니다.\n";

    private final Validator validator;

    private final Scanner scanner;

    public InputView(final Scanner scanner) {
        this.validator = new Validator();
        this.scanner = scanner;
    }

    public String askBallNumbers() {
        return ask(ASK_NUMBERS_MESSAGE, Validator.NUMBERS_PATTERN);
    }

    public boolean askRetry() {
        final String retryNumber = ask(ASK_RETRY_NUMBER, Validator.RETRY_PATTERN);
        return retryNumber.equals(BaseballGame.GAME_END);
    }

    private String ask(final String message, final Pattern pattern) {
        System.out.print(message);

        String input = scanner.nextLine();

        while (!isValid(input, pattern)) {
            System.out.print(message);
            input = scanner.nextLine();
        }

        return input;
    }

    private boolean isValid(final String input, final Pattern pattern) {
        try {
            validator.validateNumbers(pattern, input);
        } catch (IllegalArgumentException e) {
            System.out.printf(e.getMessage() + INPUT_VALUE_FORMAT, input);
            return false;
        }

        return true;
    }
}
