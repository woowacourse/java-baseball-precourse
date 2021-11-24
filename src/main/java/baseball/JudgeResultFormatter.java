package baseball;

public class JudgeResultFormatter {
	public String format(JudgeResult result) {
		if(result.equals(JudgeResult.nothing())) {
			return "낫싱";
		}

		String message = "";

		if (result.getBall() > 0) {
			message += result.getBall() + "볼 ";
		}

		if(result.getStrike() > 0) {
			message += result.getStrike() + "스트라이크 ";
		}

		return message.substring(0, message.length() - 1);
	}
}
