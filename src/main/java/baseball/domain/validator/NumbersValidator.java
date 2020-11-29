package baseball.domain.validator;

import java.util.regex.Pattern;

import baseball.BaseballGame;

public class NumbersValidator extends Validator {

    public static final String DUPLICATE_NUMBER_MESSAGE = "중복된 값이 입력되었습니다!";

    public static final Pattern NUMBERS_PATTERN =
            Pattern.compile(String.format("[1-9]{%d}", BaseballGame.BALLS_LENGTH));

    @Override
    public void validate(final String input) {
        super.validate(input);
        checkRegularExpression(NUMBERS_PATTERN, input);
        checkDuplicateNumber(input);
    }


    private void checkDuplicateNumber(final String input) {
        final int deduplicatedNumbersLength = (int) input.chars().distinct().count();
        if (deduplicatedNumbersLength != BaseballGame.BALLS_LENGTH) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER_MESSAGE);
        }
    }
}
