package baseball;

public class Hint {

	int strike = 0;
	int ball = 0;
	String hint;
	boolean flag = false; // 게임 종료 여부
	
	// 한 번의 힌트를 계산한 후 strike와 ball의 값을 초기화하는 함수
	public void clearStrikeAndBall() {
		this.strike = 0;
		this.ball = 0;
	}

	// 출력할 힌트를 만드는 함수
	public void makeHint(int[] answerNum, int[] playerNum) {
		for (int i = 0; i < Constant.NUM_LEN; i++) {
			// strike인 경우는 제외하고 ball을 카운트 해야한다.
			if (answerNum[i] != playerNum[i])
				countBall(i, answerNum, playerNum);
			// 같은 자리의 수로 strike 여부를 카운트한다.
			countStrike(answerNum[i], playerNum[i]);
		}
		printHint();
	}

	// strike 갯수를 카운트하는 함수
	public void countStrike(int a, int b) {
		if (a == b) strike++;
	}

	// ball 갯수를 카운트하는 함수
	public void countBall(int i, int[] answerNum, int[] playerNum) {
		for (int j = 0; j < Constant.NUM_LEN; j++) {
			if (i == j) continue;
			if (answerNum[i] == playerNum[j]) ball++;
		}
	}
	
	// strike와 ball의 갯수에 따라 힌트를 출력하는 함수
	public void printHint() {
		if (strike == Constant.NUM_LEN) {
			hint = "3 스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임을 종료합니다.\n";
			flag = true;
		} else if (strike == 0 && ball == 0) {
			hint = "낫싱\n";
		} else if (strike == 0) {
			hint = String.format("%d볼\n", ball);
		} else if (ball == 0) {
			hint = String.format("%d스트라이크\n", strike);
		} else {
			hint = String.format("%d볼 %d스트라이크\n", ball, strike);
		}
		System.out.print(hint);
	}
}
