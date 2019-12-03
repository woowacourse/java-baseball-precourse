package baseballgame;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * @author KSKIM
 * @version 1.0.0
 * @since 2019-11-28
 */
public class Number {
    private static final String EXCEPTION_INVALID_NUMBER_COUNT = "숫자의 크기가 적합하지 않습니다.";
    private static final String EXCEPTION_NOT_NUMBER = "1~9 사이의 수로 구성된 수가 아닙니다.";
    private static final String EXCEPTION_HAS_DUPLICATE = "중복된 수가 있습니다.";
    public static final Integer TOTAL_NUMBER = 3;
    public static final Integer MIN_DIGIT = 1;
    public static final Integer MAX_DIGIT = 9;

    private final List<Integer> number;

    public Number(List<Integer> number) {
        validateSize(number);
        validateRange(number);
        validateDuplication(number);
        this.number = Objects.requireNonNull(number);
    }

    private void validateSize(List<Integer> number) {
        if (number.size() != 3) {
            throw new IllegalArgumentException(EXCEPTION_INVALID_NUMBER_COUNT);
        }
    }

    private void validateRange(List<Integer> number) {
        for (int value: number) {
            if (value < MIN_DIGIT || value > MAX_DIGIT) {
                throw new IllegalArgumentException(EXCEPTION_NOT_NUMBER);
            }
        }
    }

    private void validateDuplication(List<Integer> number) {
        Set<Integer> includedValue = new HashSet<>();
        for (int value: number) {
            if (includedValue.contains(value)) {
                throw new IllegalArgumentException(EXCEPTION_HAS_DUPLICATE);
            }
            includedValue.add(value);
        }
    }

    public Integer get(int index) {
        return number.get(index);
    }

    public boolean contains(Integer input) {
        return number.contains(input);
    }

    public static Number valueOf(String string) {
        return new Number(parseIntegers(string));
    }

    private static List<Integer> parseIntegers(String string) {
        List<Integer> number = new ArrayList<>();
        for (char digit: string.toCharArray()) {
            number.add(Character.getNumericValue(digit));
        }
        return number;
    }
}
