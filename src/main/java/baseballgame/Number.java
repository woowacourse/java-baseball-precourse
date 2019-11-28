package baseballgame;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author KSKIM
 * @version 1.0.0
 * @since 2019-11-28
 */
public class Number {
    private static final String EXCEPTION_NOT_NUMBER = "1~9 사이의 수로 구성된 세 자리 수가 아닙니다.";
    private static final String EXCEPTION_HAS_DUPLICATE = "중복된 수가 있습니다.";
    public static final Integer TOTAL_NUMBER = 3;
    public static final Integer MIN_DIGIT = 1;
    public static final Integer MAX_DIGIT = 9;

    private final List<Integer> number;

    public Number(List<Integer> number) {
        this.number = Objects.requireNonNull(number);
    }

    public Integer get(int index) {
        return number.get(index);
    }

    public boolean contains(Integer input) {
        return number.contains(input);
    }

    public static Number valueOf(List<Integer> number) {
        return new Number(number);
    }

    public static Number valueOf(String string) {
        return new Number(parseIntegers(string));
    }

    private static List<Integer> parseIntegers(String string) {
        if (!NumberValidator.isNumber(string)) {
            throw new IllegalArgumentException(EXCEPTION_NOT_NUMBER);
        }

        if (NumberValidator.hasDuplicate(string)) {
            throw new IllegalArgumentException(EXCEPTION_HAS_DUPLICATE);
        }

        List<Integer> number = new ArrayList<>();
        for (char digit: string.toCharArray()) {
            number.add(Character.getNumericValue(digit));
        }
        return number;
    }
}
