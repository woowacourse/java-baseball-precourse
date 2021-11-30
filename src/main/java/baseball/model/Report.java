package baseball.model;

public class Report {
	GuessNumbers guessNumbers;
	String report;

	public Report(GuessNumbers guessNumbers) {
		this.guessNumbers = guessNumbers;

	}

	public String getReport() {
		if (guessNumbers.countStrike() == 3) {
			return guessNumbers.countStrike() + "스트라이크" + "\n" + "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
		}

		if (guessNumbers.isNothing()) {
			return "낫싱";
		}

		if (!guessNumbers.hasBall()) {
			return guessNumbers.countStrike() + "스트라이크";
		}

		if (!guessNumbers.hasStrike()) {
			return guessNumbers.countBall() + "볼";
		}

		return guessNumbers.countBall() + "볼" + " " + guessNumbers.countStrike() + "스트라이크";
	}
}
