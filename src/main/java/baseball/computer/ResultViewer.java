package baseball.computer;

import baseball.constant.Constant;

public class ResultViewer {

	public String showResult(int strikeCnt, int ballCnt) {
		if (ballCnt == 0 && strikeCnt == 0) {
			return Constant.NOTHING_MESSAGE;
		}
		if (strikeCnt == 0) {
			return String.format(Constant.BALL_MESSAGE, ballCnt);
		}
		if (ballCnt == 0) {
			return String.format(Constant.STRIKE_MESSAGE, strikeCnt);
		}
		return String.format(Constant.BALL_AND_STRIKE_MESSAGE, ballCnt, strikeCnt);
	}
}
