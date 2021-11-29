package baseball.utils;

import baseball.BaseballGameSystem;

import java.util.HashSet;
import java.util.List;

public class InputValidator {
    public static final int GAME_MENU_LENGTH = 1;

    public static boolean isInRange(String input, int min, int max) {
        try {
            for (int i = 0; i < input.length(); ++i) {
                int inputDigit = Character.getNumericValue(input.charAt(i));
                if (isOutOfRange(inputDigit, min, max)) {
                    throw new IllegalArgumentException();
                }
            }
        }catch(IndexOutOfBoundsException e) {
            throw new IllegalArgumentException();
        }
        return true;
    }

    public static boolean isOutOfRange(int digit, int min, int max) {
        return digit < min || digit > max;
    }

    public static boolean isSameLength(String input, int targetLength) {
        if(input.length() != targetLength) {
            throw new IllegalArgumentException();
        }
        return true;
    }

    public static boolean isUniqueDigits(String input) {
        List<Integer> inputDigits = InputUtils.convertStringToIntegerList(input);
        HashSet<Integer> hashSet = new HashSet<>(inputDigits);

        if(hashSet.size() != RandomDigitsGenerator.RANDOM_DIGIT_COUNT) {
            throw new IllegalArgumentException();
        }
        return true;
    }

    public static void validateGameDigits(String input) {
        isSameLength(input, RandomDigitsGenerator.RANDOM_DIGIT_COUNT);
        isInRange(input, RandomDigitsGenerator.RANDOM_DIGIT_MIN, RandomDigitsGenerator.RANDOM_DIGIT_MAX);
        isUniqueDigits(input);
    }

    public static void validateGameMenu(String input) {
        isSameLength(input, GAME_MENU_LENGTH);
        isInRange(input, BaseballGameSystem.GAME_RE_START, BaseballGameSystem.GAME_EXIT);
    }
}
