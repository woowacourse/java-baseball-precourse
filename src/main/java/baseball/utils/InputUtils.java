package baseball.utils;

import java.util.ArrayList;
import java.util.List;

public class InputUtils {

    public static List<Integer> convertStringToIntegerList(String input) {
        List<Integer> result = new ArrayList<>();

        for(int i = 0; i < RandomDigitsGenerator.RANDOM_DIGIT_COUNT; ++i) {
            int digit = Character.getNumericValue(input.charAt(i));
            if(InputValidator.isOutOfRange(digit, RandomDigitsGenerator.RANDOM_DIGIT_MIN, RandomDigitsGenerator.RANDOM_DIGIT_MAX)) {
                throw new IllegalArgumentException();
            }
            result.add(digit);
        }
        return result;
    }
}
