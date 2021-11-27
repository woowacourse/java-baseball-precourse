package baseball.domain;

import java.util.List;

public class Result {
	public static final String BALL_STRING = "볼";
	public static final String STRIKE_STRING = "스트라이크";
	public static final String NOTHING_STRING = "낫싱";
	public static final char SPACE = 32;
	public static final int MAX_COUNT = 3;
	public static final String EMPTY_STRING = "";

	private final List<Scores> result;

	private Result(List<Scores> result) {
		this.result = result;
	}

	public static Result from(List<Scores> result) {
		return new Result(result);
	}

	int getStrikeCount() {
		return result.stream().mapToInt(Scores::getStrikeCount).sum();
	}

	int getBallCount() {
		return result.stream().mapToInt(Scores::getBallCount).sum();
	}

	public String report() {
		StringBuilder report = new StringBuilder();
		report.append(reportBall());
		report.append(reportStrike());
		report.append(reportNothing());
		return report.toString().trim();
	}

	private String reportBall() {
		if (hasBall()) {
			return getBallCount() + BALL_STRING + SPACE;
		}
		return EMPTY_STRING;
	}

	private String reportStrike() {
		if (hasStrike()) {
			return getStrikeCount() + STRIKE_STRING;
		}
		return EMPTY_STRING;
	}

	private String reportNothing() {
		if (isNothing()) {
			return NOTHING_STRING;
		}
		return EMPTY_STRING;
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
