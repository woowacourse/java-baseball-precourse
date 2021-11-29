package baseball.utils;

import static baseball.constants.GameMessages.ERR_MESSAGE_DUPLICATE;
import static baseball.constants.GameMessages.ERR_MESSAGE_NON_NUMBER;
import static baseball.constants.GameMessages.ERR_MESSAGE_OUT_OF_RANGE;
import static baseball.constants.GameMessages.ERR_MESSAGE_WRONG_SIZE;
import static baseball.constants.GameMessages.RESTART_FLAG_ERR_MESSAGE;

import baseball.constants.NumberListConstraints;
import java.util.List;

public class GameValidator {

    public static void validateNumber(String userInput) throws IllegalArgumentException {
        try {
            Integer.valueOf(userInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERR_MESSAGE_NON_NUMBER);
        }
    }

    public static void validateRange(List<Integer> numbers) throws IllegalArgumentException {
        boolean isInRange = numbers.stream()
            .allMatch(n ->
                n >= NumberListConstraints.MIN_NUMBER.value()
                    && n <= NumberListConstraints.MAX_NUMBER.value());
        if (!isInRange) {
            throw new IllegalArgumentException(ERR_MESSAGE_OUT_OF_RANGE);
        }
    }

    public static void validateSize(List<Integer> numbers) throws IllegalArgumentException {
        if (numbers.size() != NumberListConstraints.LIST_LENGTH.value()) {
            throw new IllegalArgumentException(ERR_MESSAGE_WRONG_SIZE);
        }
    }

    public static void validateDuplicate(List<Integer> numbers) throws IllegalArgumentException {
        long uniqueElements = numbers.stream().distinct().count();
        if (uniqueElements != NumberListConstraints.LIST_LENGTH.value()) {
            throw new IllegalArgumentException(ERR_MESSAGE_DUPLICATE);
        }
    }

    public static void validateRestartFlag(int flag) throws IllegalArgumentException {
        if (flag != NumberListConstraints.RESTART_FLAG_TRUE.value()
            && flag != NumberListConstraints.RESTART_FLAG_FALSE.value()) {
            throw new IllegalArgumentException(RESTART_FLAG_ERR_MESSAGE);
        }
    }
}
