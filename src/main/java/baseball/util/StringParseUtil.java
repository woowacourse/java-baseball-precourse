package baseball.util;

import java.util.ArrayList;
import java.util.List;

public class StringParseUtil {

    private StringParseUtil() {};

    public static List<Integer> parseToInteger(String inputNumber) {
        int inputLength = inputNumber.length();
        List<Integer> inputNumbers = new ArrayList<>();
        for (int i = 0; i < inputLength; i++) {
            inputNumbers.add(Character.getNumericValue(inputNumber.charAt(i)));
        }
        return inputNumbers;
    }
}
