package baseball;

public class InputValidator {

    public static final int USER_ESTIMATION_LENGTH = 3;
    public static final int GAME_EXIT_DECISION_LENGTH = 1;
    public static final String USER_ESTIMATION_REGEX = "[0-9]+";

    public void validateUserEstimation(String input) {
        if(input.length() != USER_ESTIMATION_LENGTH) {
            throw new IllegalArgumentException(ErrorCode.INVALID_ESTIMATION_INPUT_LENGTH.getMessage());
        }

        if(!input.matches(USER_ESTIMATION_REGEX)) {
            throw new IllegalArgumentException(ErrorCode.CONTAINS_INVALID_CHARACTER.getMessage());
        }
    }

    public void validateGameExitDecision(String input) {
        if(input.length() != GAME_EXIT_DECISION_LENGTH) {
            throw new IllegalArgumentException(ErrorCode.INVALID_GAME_EXIT_DECISION.getMessage());
        }

        int userDecision;
        try {
            userDecision = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorCode.INVALID_GAME_EXIT_DECISION.getMessage());
        }

        if(userDecision < 1 || userDecision > 2) {
            throw new IllegalArgumentException(ErrorCode.INVALID_GAME_EXIT_DECISION.getMessage());
        }
    }
}
