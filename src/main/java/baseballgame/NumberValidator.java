package baseballgame;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

/**
 * @author KSKIM
 * @version 1.0.0
 * @since 2019-11-28
 */
public class NumberValidator {
    private static final String REGEX_NUMBER =
            String.format("^[%d-%d]{%d}$", Number.MIN_DIGIT, Number.MAX_DIGIT, Number.TOTAL_NUMBER);

    public static boolean isNumber(String input) {
        return Pattern.matches(REGEX_NUMBER, input);
    }

    public static boolean hasDuplicate(String string) {
        Set<Character> includedDigit = new HashSet<>();
        for (char digit: string.toCharArray()) {
            if (includedDigit.contains(digit)) {
                return true;
            }
            includedDigit.add(digit);
        }
        return false;
    }
}
