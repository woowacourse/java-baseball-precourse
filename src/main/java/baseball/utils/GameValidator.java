package baseball.utils;

import baseball.constants.NumberListConstraints;
import java.util.HashSet;
import java.util.List;

public class GameValidator {

    final private static String NON_NUMBER_MESSAGE = "숫자만 입력해주세요.";
    final private static String OUT_OF_RANGE_MESSAGE = "1 ~ 9 까지 숫자만 입력해주세요.";
    final private static String WRONG_SIZE_MESSAGE = "3 개의 숫자만 입력해주세요";
    final private static String DUPLICATE_MESSAGE = "중복된 숫자가 있습니다.";

    public static void validateNumber(String userInput) throws IllegalArgumentException {
        try {
            Integer.valueOf(userInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NON_NUMBER_MESSAGE);
        }
    }

    public static void validateRange(List<Integer> numbers) throws IllegalArgumentException {
        boolean isInRange = numbers.stream()
            .allMatch(n ->
                n >= NumberListConstraints.MIN_NUMBER.value()
                    && n <= NumberListConstraints.MAX_NUMBER.value());
        if (!isInRange) {
            throw new IllegalArgumentException(OUT_OF_RANGE_MESSAGE);
        }
    }

    public static void validateSize(List<Integer> numbers) throws IllegalArgumentException {
        if (numbers.size() != NumberListConstraints.LIST_LENGTH.value()) {
            throw new IllegalArgumentException(WRONG_SIZE_MESSAGE);
        }
    }

    public static void validateDuplicate(List<Integer> numbers) throws IllegalArgumentException {
        HashSet<Integer> set = new HashSet<>(numbers);
        if (set.size() != numbers.size()) {
            throw new IllegalArgumentException(DUPLICATE_MESSAGE);
        }
    }
}
