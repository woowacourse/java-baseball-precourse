package baseball;

import utils.ListUtils;

import java.util.*;

public class Validator {
    private final static String ERROR_NOT_POSITIVE_THREE_DIGIT = "Input should be positive three digit Integer";
    private final static String ERROR_CONTAIN_ZERO = "Input should not contain zero";
    private final static String ERROR_CONTAIN_OVERLAP = "Input should not contain overlap";
    private final static String ERROR_NOT_INT = "Input should be only Integer";
    private final static String ERROR_NOT_RE_GAME_CODE = "Input should be in reGame code (1 or 2)";

    private Validator() {}

    public static void ValidateBaseBallNumber(int number) {
        ValidatePositiveThreeDigit(number);
        ValidateNotContainZero(number);
        ValidateNotContainOverlap(number);
    }

    private static void ValidatePositiveThreeDigit(int number) {
        if ( number < 100 || number >= 1000) {
            throw new IllegalArgumentException(ERROR_NOT_POSITIVE_THREE_DIGIT);
        }
    }

    private static void ValidateNotContainZero(int number) {
        List<Integer> numbers = ListUtils.intToDigitsList(number);
        for (int x : numbers) {
            if (x == 0) {
                throw new IllegalArgumentException(ERROR_CONTAIN_ZERO);
            }
        }
    }

    private static void ValidateNotContainOverlap(int number) {
        List<Integer> numbers = ListUtils.intToDigitsList(number);
        HashSet<Integer> set = new HashSet<>();
        for (int x : numbers) {
            if (set.contains(x)) {
                throw new IllegalArgumentException(ERROR_CONTAIN_OVERLAP);
            }
            set.add(x);
        }
    }

    public static void ValidateReGameCode(int number) {
        if (number != 1 && number != 2) {
            throw new IllegalArgumentException(ERROR_NOT_RE_GAME_CODE);
        }
    }

    public static void ValidateStringToInt(String string) {
        try {
            Integer.parseInt(string);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException(ERROR_NOT_INT);
        }
    }
}
