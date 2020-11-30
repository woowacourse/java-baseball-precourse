package domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author yhh1056
 * @since 2020/11/26
 */
public class Player {
    private static final String DELIMITER = "";
    private static final String RESTART = "1";
    private static final String ENDGAME = "2";

    public BaseballNumber createBaseballNumber(String input) {
        return new BaseballNumber(createNumbers(input));
    }

    private List<Integer> createNumbers(String input) {
        validateNumber(input);
        return Arrays.stream(input.split(DELIMITER)).map(Integer::parseInt)
            .collect(Collectors.toList());
    }

    private void validateNumber(String number) {
        checkNumeric(number);
        checkNatureNumber(Integer.parseInt(number));
    }

    private void checkNumeric(String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private void checkNatureNumber(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException();
        }
    }

    public boolean choiceRestartGameOrFinish(String input) {
        switch (input) {
            case RESTART:
                return true;
            case ENDGAME:
                return false;
            default:
                throw new IllegalArgumentException();
        }
    }
}
