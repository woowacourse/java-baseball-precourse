package baseball.domain;

public class Ball {
	private final int index;
	private final int no;

	private Ball(int index, int no) {
		this.index = index;
		this.no = no;
	}

	static Ball of(int index, int no) {
		return new Ball(index, no);
	}

	public Score compare(Ball ball) {
		if (ball.isStrike(index, no)) {
			return Score.STRIKE;
		}
		if (ball.isBall(index, no)) {
			return Score.BALL;
		}
		return Score.NOTHING;
	}

	private boolean isStrike(int index, int no) {
		return this.index == index && this.no == no;
	}

	private boolean isBall(int index, int no) {
		return this.index != index && this.no == no;
	}
}
