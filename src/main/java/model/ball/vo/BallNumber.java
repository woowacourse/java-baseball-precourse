package model.ball.vo;

import java.util.Objects;

public class BallNumber {
    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 9;
    private final int value;

    public BallNumber(final int value) {
        validateNumberBoundary(value);
        this.value = value;
    }

    private void validateNumberBoundary(final int value) {
        if (value < MIN_VALUE || value > MAX_VALUE) {
            throw new IllegalArgumentException("숫자의 범위는 1 ~ 9 입니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BallNumber that = (BallNumber) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}