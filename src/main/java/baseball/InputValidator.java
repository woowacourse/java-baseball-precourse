package baseball;

public class InputValidator {

    public static final int USER_ESTIMATION_LENGTH = 3;
    public static final String USER_ESTIMATION_REGEX = "[0-9]+";

    public void validateUserEstimation(String input) {
        if(input.length() != USER_ESTIMATION_LENGTH) {
            throw new IllegalArgumentException(ErrorCode.INVALID_ESTIMATION_INPUT_LENGTH.getMessage());
        }

        if(!input.matches(USER_ESTIMATION_REGEX)) {
            throw new IllegalArgumentException(ErrorCode.CONTAINS_INVALID_CHARACTER.getMessage());
        }
    }
}
