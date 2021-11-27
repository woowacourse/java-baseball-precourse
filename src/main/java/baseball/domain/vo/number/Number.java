package baseball.domain.vo.number;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Number {

    private static final int FIRST = 0;
    private static final int SECOND = 1;
    private static final int THIRD = 2;

    private static final char ZERO_CHARACTER = '0';

    private final int first;
    private final int second;
    private final int third;

    private Number(int first, int second, int third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public Number(String numberString) {
        this(charToInt(numberString.charAt(FIRST)),
            charToInt(numberString.charAt(SECOND)),
            charToInt(numberString.charAt(THIRD)));
    }

    public Number(Set<Integer> numberSet) {
        this(new ArrayList<>(numberSet));
    }

    private Number(List<Integer> numberList) {
        this(numberList.get(FIRST), numberList.get(SECOND), numberList.get(THIRD));
    }

    public int countStrike(Number other) {
        int count = 0;

        if (equal(first, other.first)) {
            count++;
        }

        if (equal(second, other.second)) {
            count++;
        }

        if (equal(third, other.third)) {
            count++;
        }

        return count;
    }

    public int countBall(Number other) {
        int count = 0;

        if (equal(first, other.second) || equal(first, other.third)) {
            count++;
        }

        if (equal(second, other.first) || equal(second, other.third)) {
            count++;
        }

        if (equal(third, other.first) || equal(third, other.second)) {
            count++;
        }

        return count;
    }

    private static int charToInt(char c) {
        return c - ZERO_CHARACTER;
    }

    private boolean equal(int i, int j) {
        return Objects.equals(i, j);
    }

}
