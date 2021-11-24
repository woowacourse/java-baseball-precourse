package baseball;

public class JudgeResultFormatter {
	public String format(JudgeResult result) {
		if(result.isNothing()) {
			return "낫싱";
		}

		return removeLastSpaceCharacter(
			formatMessageForBallAndStrike(result));
	}

	private String removeLastSpaceCharacter(String message) {
		return message.substring(0, message.length() - 1);
	}

	private String formatMessageForBallAndStrike(JudgeResult result) {
		return formatMessageForBall(result) + formatMessageForStrike(result);
	}

	private String formatMessageForStrike(JudgeResult result) {
		if(result.hasStrike()) {
			return result.getStrike() + "스트라이크 ";
		}

		return "";
	}

	private String formatMessageForBall(JudgeResult result) {
		if (result.hasBall()) {
			return result.getBall() + "볼 ";
		}

		return "";
	}

}
