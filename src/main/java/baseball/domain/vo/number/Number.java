package baseball.domain.vo.number;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import baseball.domain.vo.BallStrikeCount;

public class Number {

    private static final int NOTHING = 0;
    private static final int THREE_STRIKE = 3;

    private int first;
    private int second;
    private int third;

    private Number(int first, int second, int third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public Number(String numberString) {
        this(charToInt(numberString.charAt(0)), charToInt(numberString.charAt(1)), charToInt(numberString.charAt(2)));
    }

    public Number(Set<Integer> numberSet) {
        this(new ArrayList<>(numberSet));
    }

    private Number(List<Integer> numberList) {
        this(numberList.get(0), numberList.get(1), numberList.get(2));
    }

    private static int charToInt(char c) {
        return c - '0';
    }


    public boolean isUnique() {
        return !equal(first, second) && !equal(first, third) && !equal(second, third);
    }

    private boolean equal(int i, int j) {
        return Objects.equals(i, j);
    }

    public BallStrikeCount compare(Number other) {
        int ballCount = countBall(other);
        int strikeCount = countStrike(other);

        if (isThreeStrike(strikeCount)) {
            return BallStrikeCount.threeStrike();
        }

        if (isNothing(ballCount, strikeCount)) {
            return BallStrikeCount.nothing();
        }

        return BallStrikeCount.newInstance(ballCount, strikeCount);
    }

    private boolean isNothing(int ballCount, int strikeCount) {
        return equal(ballCount, NOTHING) && equal(strikeCount, NOTHING);
    }

    private boolean isThreeStrike(int count) {
        return equal(count, THREE_STRIKE);
    }

    private int countStrike(Number other) {
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

    private int countBall(Number other) {
        int count = 0;

        if (equal(first, other.second) || Objects.equals(first, other.third)) {
            count++;
        }

        if (equal(second, other.first) || Objects.equals(second, other.third)) {
            count++;
        }

        if (equal(third, other.first) || Objects.equals(third, other.second)) {
            count++;
        }

        return count;
    }

}
