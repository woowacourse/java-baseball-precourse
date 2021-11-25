package baseball;

public class Ball {
    private int position;
    private int value;

    public Ball(int position, int value) {
        if (value < Constant.MIN_VALUE || value > Constant.MAX_VALUE) {
            throw new IllegalArgumentException(Constant.INVALID_NUMBER_VALUE_MESSAGE);
        }
        if (position > Constant.MAX_SIZE) {
            throw new IllegalArgumentException(Constant.INVALID_NUMBER_COUNT_MESSAGE);
        }
        this.position = position;
        this.value = value;
    }

    public int getPosition() {
        return position;
    }

    public int getValue() {
        return value;
    }
}
