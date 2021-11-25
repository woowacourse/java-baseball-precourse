package baseball.domain;

public class Referee {
	int[] playerNum;
	int[] answer;

	public Referee(int[] playerNum, int[] answer) {
		this.playerNum = playerNum;
		this.answer = answer;
	}

	public Result check() {
		int strikeCount = 0;
		int ballCount = 0;
		for (int i = 0; i < playerNum.length; i++) {
			int equalIndex = findEqualIndex(playerNum[i]);
			if (equalIndex == i) {
				strikeCount++;
			} else if (equalIndex >= 0) {
				ballCount++;
			}
		}

		return new Result(strikeCount, ballCount);
	}

	private int findEqualIndex(int target) {
		// 일치하는 값의 인덱스를 찾아낸다.
		for (int i = 0; i < answer.length; i++) {
			if (target == answer[i]) {
				return i;
			}
		}
		return -1;
	}
}
