package model.ball.vo;

import java.util.Objects;

public class BallPosition {
    private static final int MIN_VALUE = 0;
    private static final int MAX_VALUE = 2;
    private final int value;

    public BallPosition(final int value) {
        validate(value);
        this.value = value;
    }

    private void validate(final int value) {
        if (value < MIN_VALUE || value > MAX_VALUE) {
            throw new IllegalArgumentException("숫자 공이 잘못된 위치를 가집니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BallPosition that = (BallPosition) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
