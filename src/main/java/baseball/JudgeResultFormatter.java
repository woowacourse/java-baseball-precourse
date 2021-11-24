package baseball;

public class JudgeResultFormatter {
	public String format(JudgeResult result) {
		if (result.getBall() > 0) {
			return result.getBall() + "볼";
		}
		return result.getStrike() + "스트라이크";
	}
}
