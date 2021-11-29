package baseball;

public class OutputView {
	private static final String GAME_END_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

	public void printPredictionResult(PlayResult playResult) {
		StringBuilder predictionResult = new StringBuilder();
		if (playResult.getBall() > 0) {
			predictionResult.append(playResult.getBall() + "볼 ");
		}
		if (playResult.getStrike() > 0) {
			predictionResult.append(playResult.getStrike() + "스트라이크");
		}
		if (playResult.getBall() == 0 && playResult.getStrike() == 0) {
			predictionResult.append("낫싱");
		}
		System.out.println(predictionResult.toString());
	}

	public void printGameEndMessage() {
		System.out.println(GAME_END_MESSAGE);
	}
}
