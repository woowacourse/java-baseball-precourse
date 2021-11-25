package baseball.model;

import java.util.Objects;

public class Ball {

    private final int value;
    private final int index;

    public Ball(int value, int index) {
        this.value = value;
        this.index = index;
    }

    public int getValue() {
        return value;
    }

    public PlayType play(Ball opponentBall) {
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
}
