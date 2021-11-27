package baseball.utils;

import java.util.HashSet;
import java.util.List;

public class InputValidator {

    public static void validateDigit(String input) {
        for(int i = 0; i < RandomDigitsGenerator.RANDOM_DIGIT_COUNT; ++i) {
            int inputDigit = Character.getNumericValue(input.charAt(i));
            if(isOutOfRange(inputDigit)) {
                throw new IllegalArgumentException();
            }
         }
    }

    public static boolean isOutOfRange(int digit) {
        return digit < RandomDigitsGenerator.RANDOM_DIGIT_MIN || digit > RandomDigitsGenerator.RANDOM_DIGIT_MAX;
    }

    public static void validateLength(String input) {
        int inputLength = input.length();
        if(inputLength != RandomDigitsGenerator.RANDOM_DIGIT_COUNT) {
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
        validateDigit(input);
        validateLength(input);
        validateUniqueDigits(input);
    }
}
