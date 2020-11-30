package baseball;

public class Hint {

	int strike = 0;
	int ball = 0;

	// 출력할 힌트를 만드는 함수
	public void makeHint(int[] answerNum, int[] playerNum) {
		for (int i = 0; i < 3; i++) {
			// strike인 경우는 제외하고 ball을 카운트 해야한다.
			if (answerNum[i] != playerNum[i]) {
				countBall(i, answerNum, playerNum);
			// 같은 자리의 수로 strike 여부를 카운트한다.
			}else{
				countStrike(answerNum[i], playerNum[i]);
			}
		}
	}

	// strike 갯수를 카운트하는 함수
	public void countStrike(int a, int b) {
		if (a == b) strike++;
	}

	// ball 갯수를 카운트하는 함수
	public void countBall(int i, int[] answerNum, int[] playerNum) {
		for (int j = 0; j < 3; j++) {
			if (i == j) continue;
			if (answerNum[i] == playerNum[j]) ball++;
		}
	}
}
