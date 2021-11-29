package baseball.domain;

import java.util.ArrayList;
import java.util.List;

import baseball.resource.rule.NumberDigit;
import baseball.resource.text.HintText;

public class Hint {

	private int balls;
	private int strikes;

	public Hint() {
		this.balls = 0;
		this.strikes = 0;
	}

	public void increaseBall() {
		this.balls++;
	}

	public void increaseStrike() {
		this.strikes++;
	}

	public boolean isAllStrikes() {
		return NumberDigit.isMatch(this.strikes);
	}

	public String toString() {
		List<String> resultStrings = makeResultStrings();
		if (resultStrings.size() == 0) {
			return HintText.NOTHING;
		}
		return String.join(" ", resultStrings);
	}

	private List<String> makeResultStrings() {
		List<String> resultStrings = new ArrayList<>();
		if (isBallExist()) {
			resultStrings.add(getStringBalls());
		}
		if (isStrikeExist()) {
			resultStrings.add(getStringStrikes());
		}
		return resultStrings;
	}

	private boolean isBallExist() {
		return (balls != 0);
	}

	private boolean isStrikeExist() {
		return (strikes != 0);
	}

	private String getStringBalls() {
		return balls + HintText.BALL;
	}

	private String getStringStrikes() {
		return strikes + HintText.STRIKE;
	}

}
