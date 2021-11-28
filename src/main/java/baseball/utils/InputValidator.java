package baseball.utils;

import baseball.BaseballGameSystem;

import java.util.HashSet;
import java.util.List;

public class InputValidator {

    public static void validateGameDigitInRange(String input, int length) {
        for(int i = 0; i < length; ++i) {
            int inputDigit = Character.getNumericValue(input.charAt(i));
            if(isOutOfRange(inputDigit, RandomDigitsGenerator.RANDOM_DIGIT_MIN, RandomDigitsGenerator.RANDOM_DIGIT_MAX)) {
                throw new IllegalArgumentException();
            }
        }
    }

    public static void validateGameMenuDigitInRange(String input, int length) {
        for(int i = 0; i < length; ++i) {
            int inputDigit = Character.getNumericValue(input.charAt(i));
            if(isOutOfRange(inputDigit, BaseballGameSystem.GAME_RE_START, BaseballGameSystem.GAME_EXIT)) {
                throw new IllegalArgumentException();
            }
        }
    }

    public static boolean isOutOfRange(int digit, int min, int max) {
        return digit < min || digit > max;
    }

    public static void validateLength(String input, int length) {
        int inputLength = input.length();
        if(inputLength != length) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateUniqueDigits(String input) {
        List<Integer> inputDigits = InputUtils.convertStringToIntegerList(input);
        HashSet<Integer> hashSet = new HashSet<>(inputDigits);

        if(hashSet.size() != RandomDigitsGenerator.RANDOM_DIGIT_COUNT) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateGameDigits(String input) {
        validateLength(input, RandomDigitsGenerator.RANDOM_DIGIT_COUNT);
        validateGameDigitInRange(input, RandomDigitsGenerator.RANDOM_DIGIT_COUNT);
        validateUniqueDigits(input);
    }

    public static void validateGameMenu(String input) {
        validateLength(input, BaseballGameSystem.GAME_MENU_LENGTH);
        validateGameMenuDigitInRange(input, BaseballGameSystem.GAME_MENU_LENGTH);
    }
}
