package baseball.domain;

import java.util.List;

public class Result {
	public static final String BALL_STRING = "볼";
	public static final String STRIKE_STRING = "스트라이크";
	public static final String NOTHING_STRING = "낫싱";
	public static final char SPACE = 32;
	public static final int MAX_COUNT = 3;

	private final List<Scores> result;

	private Result(List<Scores> result) {
		this.result = result;
	}

	public static Result from(List<Scores> result) {
		return new Result(result);
	}

	public int getStrikeCount() {
		return result.stream().mapToInt(Scores::getStrikeCount).sum();
	}

	public int getBallCount() {
		return result.stream().mapToInt(Scores::getBallCount).sum();
	}

	public String report() {
		StringBuilder sb = new StringBuilder();
		if (hasBall()) {
			sb.append(getBallCount() + BALL_STRING + SPACE);
		}
		if (hasStrike()) {
			sb.append(getStrikeCount() + STRIKE_STRING);
		}
		if (isNothing()) {
			sb.append(NOTHING_STRING);
		}
		return sb.toString().trim();
	}

	private boolean hasBall() {
		return result.stream().anyMatch(Scores::hasBall);
	}

	private boolean hasStrike() {
		return result.stream().anyMatch(Scores::hasStrike);
	}

	private boolean isNothing() {
		return !hasBall() && !hasStrike();
	}

	public boolean is3Strike() {
		return getStrikeCount() == MAX_COUNT;
	}
}
