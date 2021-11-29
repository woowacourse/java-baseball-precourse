package baseball.computer;

public class ResultViewer {

	public String showResult(int strikeCnt, int ballCnt) {
		if (ballCnt == 0 && strikeCnt == 0) {
			return "낫싱";
		}
		if (strikeCnt == 0) {
			return ballCnt + "볼";
		}
		if (ballCnt == 0) {
			return strikeCnt + "스트라이크";
		}
		return ballCnt + "볼 " + strikeCnt + "스트라이크";
	}
}
