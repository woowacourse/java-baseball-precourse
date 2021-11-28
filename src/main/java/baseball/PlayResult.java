package baseball;

public class PlayResult {
	private static final int GAME_END_STRIKE = 3;
	private int strike;
	private int ball;

	public int getStrike() {
		return strike;
	}

	public int getBall() {
		return ball;
	}

	public void report(BallStatus ballStatus) {
		if (ballStatus == BallStatus.STRIKE) {
			this.strike++;
		} else if (ballStatus == BallStatus.BALL) {
			this.ball++;
		}
		return;
	}

	public boolean isGameEnd() {
		return this.strike == GAME_END_STRIKE;
	}
}
