package baseball.view;

public class ResultView {

	public void printEndMessage() {
		System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
	}

	public void printResult(int ball, int strike) {
		StringBuilder stringBuilder = new StringBuilder();

		if (ball > 0) {
			stringBuilder.append(ball + "볼 ");
		}
		if (strike > 0) {
			stringBuilder.append(strike + "스트라이크");
		}
		if (ball == 0 && strike == 0) {
			stringBuilder.append("낫싱");
		}
		System.out.println(stringBuilder.toString().trim());
	}
}
