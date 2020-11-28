package baseball.domain;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import baseball.BaseballGame;

public class Validator {

    public static final String INPUT_NULL_MESSAGE = "null 값을 입력하셨습니다!";

    public static final String INVALID_VALUE_MESSAGE = "잘못된 값을 입력하셨습니다!";

    public static final Pattern NUMBERS_PATTERN = Pattern.compile("[1-9]{" + BaseballGame.BALLS_LENGTH + "}");

    public static final Pattern RETRY_PATTERN = Pattern.compile("^1$|^2$");

    public void validateNumbers(Pattern pattern, String input) {
        checkNull(input);
        checkRegularExpression(pattern, input);
    }

    private void checkNull(String input) {
        if (Objects.isNull(input)) {
            throw new IllegalArgumentException(INPUT_NULL_MESSAGE);
        }
    }

    private void checkRegularExpression(Pattern pattern, String input) {
        Matcher matcher = pattern.matcher(input);
        if (!matcher.matches()) {
            throw new IllegalArgumentException(INVALID_VALUE_MESSAGE);
        }
    }
}
