package baseball.model;

import java.util.Objects;

public class Ball {

    private final int value;
    private final int index;

    /**
     * 초기 index는 1부터 시작합니다
     */
    public Ball(int value, int index) {
        this.value = value;
        this.index = index;
    }

    public int getValue() {
        return value;
    }

    // 1:1 관계
    public PlayType compare(Ball opponentBall) {
        if (this.equals(opponentBall)) {
            return PlayType.STRIKE;
        }
        if (this.value == opponentBall.getValue()) {
            return PlayType.BALL;
        }
        return PlayType.NOTHING;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ball)) return false;
        Ball ball = (Ball) o;
        return getValue() == ball.getValue() && index == ball.index;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue(), index);
    }

    @Override
    public String toString() {
        return "Ball{" +
                "value=" + value +
                ", index=" + index +
                '}';
    }
}
