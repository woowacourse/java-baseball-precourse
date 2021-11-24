package baseball.domain;

public class Ball {
	private final Index index;
	private final No no;

	private Ball(int index, int no) {
		this.index = new Index(index);
		this.no = new No(no);
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

	private boolean isStrike(Index index, No no) {
		return this.index.equals(index) && this.no.equals(no);
	}

	private boolean isBall(Index index, No no) {
		return !this.index.equals(index) && this.no.equals(no);
	}
}
