package baseball;

import java.util.Objects;

public class BaseBallPosition {
    public static final int MIN_POSITION = 1;
    public static final int MAX_POSITION = 3;
    private final int position;

    public BaseBallPosition(int position) {
        validatePosition(position);
        this.position = position;
    }

    private void validatePosition(int position) {
        if (position < MIN_POSITION || MAX_POSITION < position) {
            throw new IllegalArgumentException(position + "는 올바른 위치가 아닙니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseBallPosition that = (BaseBallPosition) o;
        return position == that.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }

    @Override
    public String toString() {
        return "BaseBallPosition{" +
                "position=" + position +
                '}';
    }
}
