package domain;

public class Score {
	private static final String STRIKE_MESSAGE = "%d Ω∫∆Æ∂Û¿Ã≈© ";
	private static final String BALL_MESSAGE = "%d ∫º";
	private static final String NOTHING = "≥¥ΩÃ";
	private static final int MAX_STRIKE_COUNT = 3;

	private final int strike;
	private final int ball;

	public Score(int strike, int ball) {
		this.strike = strike;
		this.ball = ball;
	}

	public String message() {
		StringBuilder message = new StringBuilder();
		message.append(strikeMessage());
		message.append(ballMessage());
		message.append(nothing());
		return message.toString();
	}

	private String strikeMessage() {
		if (isStrike()) {
			return String.format(STRIKE_MESSAGE, strike);
		}
		return "";
	}

	private boolean isStrike() {
		return (strike != 0);
	}

	private String ballMessage() {
		if (isBall()) {
			return String.format(BALL_MESSAGE, ball);
		}
		return "";
	}

	private boolean isBall() {
		return (ball != 0);
	}

	private String nothing() {
		if (!isStrike() && !isBall()) {
			return NOTHING;
		}
		return "";
	}

	public boolean isMaxStrikeCount() {
		return strike == MAX_STRIKE_COUNT;
	}

}
