package baseball.view;

import java.util.Scanner;

import baseball.BaseballGame;
import baseball.domain.validator.NumbersValidator;
import baseball.domain.validator.RetryValidator;
import baseball.domain.validator.Validator;

public class InputView {

    private static final String ASK_NUMBERS_MESSAGE = "숫자를 입력해주세요 : ";

    private static final String ASK_RETRY_NUMBER = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n";

    private static final String INPUT_VALUE_FORMAT = "\n입력한 값은 %s 입니다.\n";

    private final Scanner scanner;

    private final NumbersValidator numbersValidator;

    private final RetryValidator retryValidator;

    public InputView(final Scanner scanner) {
        this.scanner = scanner;
        numbersValidator = new NumbersValidator();
        retryValidator = new RetryValidator();
    }

    public String askBallNumbers() {
        return ask(ASK_NUMBERS_MESSAGE, numbersValidator);
    }

    public boolean askRetry() {
        final String retryNumber = ask(ASK_RETRY_NUMBER, retryValidator);
        return retryNumber.equals(BaseballGame.GAME_END);
    }

    private String ask(final String message, final Validator validator) {
        System.out.print(message);

        String input = scanner.nextLine();

        while (!isValid(input, validator)) {
            System.out.print(message);
            input = scanner.nextLine();
        }

        return input;
    }

    private boolean isValid(final String input, final Validator validator) {
        try {
            validator.validate(input);
        } catch (IllegalArgumentException e) {
            System.out.printf(e.getMessage() + INPUT_VALUE_FORMAT, input);
            return false;
        }

        return true;
    }
}
