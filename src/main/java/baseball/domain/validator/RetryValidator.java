package baseball.domain.validator;

import java.util.regex.Pattern;

public class RetryValidator extends Validator {

    public static final Pattern RETRY_PATTERN = Pattern.compile("^1$|^2$");

    @Override
    public void validate(final String input) {
        super.validate(input);
        checkRegularExpression(RETRY_PATTERN, input);
    }
}
