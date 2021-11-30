package baseball.ball;

import baseball.Constant;

public class Ball {
	private int position;
	private int value;

	public Ball(int position, int value) {
		if (value < Constant.BALL_MIN_VALUE || value > Constant.BALL_MAX_VALUE) {
			throw new IllegalArgumentException(Constant.INVALID_NUMBER_VALUE_MESSAGE);
		}
		if (position > Constant.BALL_LIST_SIZE) {
			throw new IllegalArgumentException(Constant.INVALID_NUMBER_COUNT_MESSAGE);
		}
		this.position = position;
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		Ball ball = (Ball)obj;
		return position == ball.position && value == ball.value;
	}
}
