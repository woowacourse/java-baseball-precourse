package baseball.domain.validator;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    public static final String INPUT_NULL_MESSAGE = "null 값을 입력하셨습니다!";

    public static final String INPUT_EMPTY_MESSAGE = "빈 값을 입력하셨습니다!";

    public static final String INVALID_VALUE_MESSAGE = "잘못된 값을 입력하셨습니다!";

    public static final String EMPTY = "";

    protected Validator() {}

    public void validate(final String input) {
        checkNull(input);
        checkBlank(input);
    }

    private void checkNull(final String input) {
        if (Objects.isNull(input)) {
            throw new IllegalArgumentException(INPUT_NULL_MESSAGE);
        }
    }

    private void checkBlank(final String input) {
        if (input.trim().equals(EMPTY)) {
            throw new IllegalArgumentException(INPUT_EMPTY_MESSAGE);
        }
    }

    protected void checkRegularExpression(final Pattern pattern, final String input) {
        final Matcher matcher = pattern.matcher(input);
        if (!matcher.matches()) {
            throw new IllegalArgumentException(INVALID_VALUE_MESSAGE);
        }
    }
}
